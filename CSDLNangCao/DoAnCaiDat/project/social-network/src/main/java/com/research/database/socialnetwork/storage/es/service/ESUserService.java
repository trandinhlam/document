package com.research.database.socialnetwork.storage.es.service;

import com.research.database.socialnetwork.storage.es.dto.ESSearchUserDTO;
import com.research.database.socialnetwork.storage.es.entity.ESUser;
import com.research.database.socialnetwork.storage.es.entity.ESUserRepository;
import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import com.research.database.socialnetwork.storage.mysql.repo.FriendRepository;
import com.research.database.socialnetwork.utils.CommonConfig;
import org.elasticsearch.common.inject.Inject;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ESUserService {
    private ElasticsearchOperations esRestTemplate;
    private ESUserRepository esUserRepository;
    private ModelMapper mapper;
    private FriendRepository friendRepository;

    @Inject
    public ESUserService(ElasticsearchOperations esRestTemplate, ESUserRepository esUserRepository,//
                         ModelMapper mapper, FriendRepository friendRepository) {
        this.esRestTemplate = esRestTemplate;
        this.esUserRepository = esUserRepository;
        this.mapper = mapper;
        this.friendRepository = friendRepository;
    }

    public List<ESSearchUserDTO> searchByName(String name, Pageable paging) {
        Map<Integer, Friend> friends = getFriendOfLoginUser().stream() //
                .collect(Collectors.toMap(Friend::getReceiver, Function.identity()));

        return esUserRepository.findByNameContaining(name, paging).stream() //
                .map(item -> mappingWithFriend(item, friends)) //
                .collect(Collectors.toList());
    }

    private ESSearchUserDTO mappingWithFriend(ESUser itemSearch, Map<Integer, Friend> friends) {
        Friend requestedFriend = null;
        if (friends.containsKey(itemSearch.getUserId())) {
            requestedFriend = friends.get(itemSearch.getUserId());
        }
        ESSearchUserDTO result = mapper.map(itemSearch, ESSearchUserDTO.class);
        updateRelation(result, requestedFriend);
        return result;
    }

    private void updateRelation(ESSearchUserDTO result, Friend requestedFriend) {
        result.setRequested(false);
        if (Objects.nonNull(requestedFriend)) {
            result.setRequested(true);
            result.setFriendRequestedStatus(requestedFriend.getTrangthai());
        }
    }

    private List<Friend> getFriendOfLoginUser() {
        Integer principalId = CommonConfig.MY_ID;
        return friendRepository.findByInviter(principalId);
    }
}

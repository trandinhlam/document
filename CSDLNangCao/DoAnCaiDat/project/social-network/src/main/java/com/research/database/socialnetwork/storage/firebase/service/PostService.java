package com.research.database.socialnetwork.storage.firebase.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1beta1.ArrayValue;
import com.research.database.socialnetwork._enum.FriendStatus;
import com.research.database.socialnetwork.storage.firebase.dto.PostDTO;
import com.research.database.socialnetwork.storage.firebase.entity.CommonPostData;
import com.research.database.socialnetwork.storage.firebase.entity.Owner;
import com.research.database.socialnetwork.storage.firebase.entity.Post;
import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.repo.UserRepository;
import com.research.database.socialnetwork.storage.mysql.service.IFriendService;
import com.research.database.socialnetwork.utils.CommonConfig;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class PostService {

    public static final String COL_NAME = "post";
    private Integer principal = CommonConfig.MY_ID;

    @Autowired
    private IFriendService friendService;

    @Autowired
    private UserRepository userRepository;

    public String savePost(PostDTO postDTO) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference commonDataReference = dbFirestore.collection(COL_NAME).document(principal.toString());
        User principal = userRepository.findById(this.principal)//
                .orElseThrow(() -> new RuntimeException("User ís not exits!"));

        commonDataReference.set(CommonPostData.builder()
                .userName(principal.getName())
                .userId(principal.getUserId())
                .build());
        Post postEntity = mapping(postDTO, principal);
        commonDataReference.collection("newFeed").document(postEntity.getUuid()).set(postEntity);
        ApiFuture<WriteResult> collectionsApiFuture = commonDataReference.collection("myPost").document(postEntity.getUuid()).set(postEntity);
        savePostToFriendNewFeed(principal, postEntity);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public List<Post> getOwnerPost(Integer ownerId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        List<QueryDocumentSnapshot> documents = dbFirestore.collection(COL_NAME)
                .document(ownerId.toString())
                .collection("myPost")
                .orderBy("dateCreated", Query.Direction.DESCENDING)
                .get()
                .get()
                .getDocuments();
        return documents.stream()//
                .map(item -> item.toObject(Post.class))
                .collect(Collectors.toList());
    }

    public List<Post> getNewFeedByUserId(Integer userId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        List<QueryDocumentSnapshot> documents = dbFirestore.collection(COL_NAME)
                .document(userId.toString())
                .collection("newFeed")
                .orderBy("dateCreated", Query.Direction.DESCENDING)
                .get()
                .get()
                .getDocuments();
        return documents.stream()//
                .map(item -> item.toObject(Post.class))
                .collect(Collectors.toList());
    }

    private boolean savePostToFriendNewFeed(User principal, Post post) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = dbFirestore.collection(COL_NAME);
        List<Integer> friendIds = friendService.getAllFriendIds(principal.getUserId(), FriendStatus.ACCEPTED.getValue());
        friendIds.stream().forEach(item -> {
            collectionReference.document(item.toString())
                    .collection("newFeed")
                    .document(post.getUuid()).set(post);
        });
        return true;
    }
    private Post mapping(PostDTO DTO, User principal) {
        Owner owner = new Owner();
        owner.setUserId(principal.getUserId());
        owner.setName(principal.getName());
        Post post = new Post();
        post.setUuid(UUID.randomUUID().toString());
        post.setContent(DTO.getContent());
        post.setOwner(owner);
        return post;
    }
}

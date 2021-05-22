package com.research.database.socialnetwork.controller;

import com.research.database.socialnetwork._enum.FriendStatus;
import com.research.database.socialnetwork.storage.es.service.ESUserService;
import com.research.database.socialnetwork.storage.firebase.dto.PostDTO;
import com.research.database.socialnetwork.storage.firebase.entity.Post;
import com.research.database.socialnetwork.storage.firebase.service.PostService;
import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.service.IFriendService;
import com.research.database.socialnetwork.storage.mysql.service.IUserService;
import com.research.database.socialnetwork.storage.neo4j.Neo4jService;
import com.research.database.socialnetwork.utils.AgeUtils;
import com.research.database.socialnetwork.utils.CommonConfig;
import com.research.database.socialnetwork.utils.DataUtils;
import com.research.database.socialnetwork.utils.SuggestCriteria;
import com.research.database.socialnetwork.view.LayoutView;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Controller
public class UserController {

    public static final int FRIEND_DEPTH = 3;
//    public static final Integer CURRENT_USER_ID = CommonConfig.MY_ID;

    @Autowired
    private IUserService userService;

    @Autowired
    private IFriendService friendService;

    @Autowired
    private ESUserService esUserService;

    @Autowired
    private Neo4jService neo4jService;

    @Autowired
    private DataUtils dataUtils;

    @Autowired
    PostService postService;

    @GetMapping("/home")
    public String home(Model model) throws ExecutionException, InterruptedException {
        // TODO [Minh]: add suggestion criteria box
        User currentUser = (User) userService.getById(CommonConfig.MY_ID).get();
        SuggestCriteria criteria = SuggestCriteria.builder().friendDepth(FRIEND_DEPTH)
                .generation(AgeUtils.calculateGenerationFromBirthday(currentUser.getBirth()))
                .city(StringUtils.lowerCase(currentUser.getCity())).build();
        List<Integer> suggestedUserIds = Collections.emptyList(); /*neo4jService.suggestFriendIds(CURRENT_USER_ID, criteria);*/
        model.addAttribute("suggestedUsers", userService.getByIds(suggestedUserIds));
        model.addAttribute("newFeed", postService.getNewFeedByUserId(CommonConfig.MY_ID));
        model.addAttribute("principal", CommonConfig.MY_ID);
        return "home";
    }

    @GetMapping("/")
    public String index(Model model) throws ExecutionException, InterruptedException {
        return "index";
    }

    @GetMapping("/profile/my/{id}")
    public String getMyProfile(@PathVariable Integer id, Model model) throws ExecutionException, InterruptedException {
        return _profile(id, id, model, true);
    }

    @GetMapping("/profile/{id}")
    public String getProfile(@PathVariable Integer id, Model model) throws ExecutionException, InterruptedException {
        int myId = CommonConfig.MY_ID;
        //init data random bạn bè
//        dataUtils.initrandom();
//        dataUtils.putFriendIntoGraph();
//        dataUtils.putAgeIntoGraph();
//        dataUtils.putGenderIntoGraph();
        return _profile(myId, id, model, false);
    }


    private String _profile(int myId, Integer id, Model model, boolean isMyProfile) throws ExecutionException, InterruptedException {
        Optional<User> userOpt = userService.getById(id);
        User user = userOpt.get();
        Friend friend = friendService.getItem(myId, id);
        List<Integer> allFriendIds = friendService.getAllFriendIds(id, FriendStatus.ACCEPTED.getValue());
        if (allFriendIds != null && !allFriendIds.isEmpty()) {
            List<User> friends = userService.getByIds(allFriendIds);
            LayoutView.renderFriends(myId, friends, model);
        }
        //load danh sách chờ kết bạn
        List<User> waitingApproved = _getWaiting(myId);
        LayoutView.renderWaitings(myId, waitingApproved, model);

        //Checking for show editer create post
        model.addAttribute("isMyProfile", isMyProfile);
        //loading my post
        List<Post> myPosts = postService.getOwnerPost(id);
        model.addAttribute("ownerPost", myPosts);
        return _returnUser(myId, user, model, friend);
    }

    private List<User> _getWaiting(int myId) {
        List<Integer> waitingIds = friendService.getAllWaitingIds(myId);
        if (waitingIds == null || waitingIds.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return userService.getByIds(waitingIds);
    }

    @PostMapping("/profile/addfriend")
    public String addFriend(@RequestParam Map<String, String> body, Model model) {
        Integer id = Integer.valueOf(body.get("id"));
        Integer myId = Integer.valueOf(body.get("myId"));
        Optional<User> userOpt = userService.getById(id);
        User user = userOpt.get();
        if (id == myId) {
            return _returnUser(myId, user, model, null);
        }
        Friend friend = friendService.addMyFriend(user.getUserId(), myId);
        return "redirect:/profile/" + user.getUserId();
    }

    @GetMapping("/timkiembanbe")
    public String timkiembanbe(Model model) {
        return "timkiembanbe";
    }
    private String _returnUser(int myId, User user, Model model, Friend friend) {
        LayoutView.renderLayout(myId, model);
        LayoutView.renderUser(myId, user, friend, model);
        return "profile";
    }
}

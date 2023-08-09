package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("테스트_결과에_보여_줄_이름")
    void findByArticleId() {
        /* case 1 : 4번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 4L;

            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 3. 예상 데이터
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
            Comment a = new Comment(1L, article, "lee", "헝거게임");
            Comment b = new Comment(2L, article, "jay", "굿 윌 헌팅");
            Comment c = new Comment(3L, article, "park", "메이즈러너");
            List<Comment> expected = Arrays.asList(a, b, c);


            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");

        }

        /* case 2 : 1번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 1L;

            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 3. 예상 데이터
            Article article = new Article(1L, "aaaa", "1111");
            List<Comment> expected = Arrays.asList();

            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글이 없음");

        }

        /* case 3 : 9번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 9L;

            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 3. 예상 데이터
            List<Comment> expected = Arrays.asList();

            // 4. 비교 및 검증
            assertEquals(expected, comments, "9번 게시글이 없기 때문에 댓글을 조회할 수 없음!");

        }

        /* case 4 : 999번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 999L;

            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 3. 예상 데이터
            List<Comment> expected = Arrays.asList();

            // 4. 비교 및 검증
            assertEquals(expected, comments, "999번 게시글이 없기 때문에 댓글을 조회할 수 없음!");

        }

        /* case 3 : -1번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = -1L;

            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 3. 예상 데이터
            List<Comment> expected = Arrays.asList();

            // 4. 비교 및 검증
            assertEquals(expected, comments, "-1번 게시글이 없기 때문에 댓글을 조회할 수 없음!");

        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* case 1 : "park"의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            String nickname = "park";

            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);

            // 3. 예상 데이터
            Comment a = new Comment(3L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"), nickname, "메이즈러너");
            Comment b = new Comment(6L, new Article(5L, "당신의 드림카는?", "댓글 ㄲ"), nickname, "아우디");
            Comment c = new Comment(9L, new Article(6L, "당신의 특기는?", "댓글 ㄱㄱㄱ"), nickname, "미술");
            List<Comment> expected = Arrays.asList(a, b, c);

            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "park의 모든 댓글을 출력!");

        }

        /* case 2 : "jay"의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            String nickname = "jay";

            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);

            // 3. 예상 데이터
            Comment a = new Comment(2L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"), nickname, "굿 윌 헌팅");
            Comment b = new Comment(5L, new Article(5L, "당신의 드림카는?", "댓글 ㄲ"), nickname, "벤츠");
            Comment c = new Comment(8L, new Article(6L, "당신의 특기는?", "댓글 ㄱㄱㄱ"), nickname, "헬스");
            List<Comment> expected = Arrays.asList(a, b, c);

            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "park의 모든 댓글을 출력!");

        }

        /* case 3 : null의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            String nickname = null;

            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);

            // 3. 예상 데이터
            List<Comment> expected = Arrays.asList();

            // 4. 비교 및 검증
            assertEquals(expected, comments, "null의 댓글은 존재하지 않음!");

        }


        /* case 3 : ""의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            String nickname = "";

            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);

            // 3. 예상 데이터
            List<Comment> expected = Arrays.asList();

            // 4. 비교 및 검증
            assertEquals(expected, comments, "\"\" 댓글은 존재하지 않음!");


        }
    }





}
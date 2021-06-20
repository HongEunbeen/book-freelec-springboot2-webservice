package eun.example.book.service.posts;

import eun.example.book.domain.posts.Posts;
import eun.example.book.domain.posts.PostsRepository;
import eun.example.book.web.dto.PostsResponseDto;
import eun.example.book.web.dto.PostsSaveRequestDto;
import eun.example.book.web.dto.PostsUpdateReqeustDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateReqeustDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalAccessError("해당 게시글이 없습니다. id" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalAccessError("해당 게시글이 없습니다. id" + id));
        return new PostsResponseDto(entity);

    }


}

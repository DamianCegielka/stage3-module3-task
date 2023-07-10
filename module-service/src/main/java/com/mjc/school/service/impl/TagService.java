package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.entity.TagModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import com.mjc.school.service.exception.TagIsDoesNotExistException;
import com.mjc.school.service.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService implements BaseService<TagDtoRequest, TagDtoResponse, Long> {

    private final BaseRepository<TagModel, Long> tagRepository;

    @Autowired
    public TagService(BaseRepository<TagModel, Long> tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Override
    public List<TagDtoResponse> readAll() {
        return tagRepository.readAll().stream()
                .map(TagMapper.INSTANCE::tagModelToDto)
                .toList();
    }

    @Override
    public TagDtoResponse readById(Long id) {

        Optional<TagModel> tagModel = tagRepository.readById(id);
        if (tagModel.isPresent()) {
            return TagMapper.INSTANCE.tagModelToDto(tagModel.get());
        } else {
            throw new TagIsDoesNotExistException();
        }
    }

    @Override
    public TagDtoResponse create(TagDtoRequest createRequest) {
        TagModel tagModel = tagRepository.create(TagMapper.INSTANCE.tagDtoToModel(createRequest));
        return TagMapper.INSTANCE.tagModelToDto(tagModel);
    }

    @Override
    public TagDtoResponse update(TagDtoRequest updateRequest) {

        if (tagRepository.existById(updateRequest.getId())) {
            TagModel tagModel = tagRepository.update(TagMapper.INSTANCE.tagDtoToModel(updateRequest));
            return TagMapper.INSTANCE.tagModelToDto(tagModel);
        } else {
            throw new TagIsDoesNotExistException();
        }
    }

    @Override
    public boolean deleteById(Long id) {

        if (tagRepository.existById(id)) {
            return tagRepository.deleteById(id);
        } else {
            throw new TagIsDoesNotExistException();
        }
    }
}


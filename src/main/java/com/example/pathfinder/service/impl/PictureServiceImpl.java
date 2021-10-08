package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.view.PictureViewModel;
import com.example.pathfinder.repo.PictureRepo;
import com.example.pathfinder.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepo pictureRepo;
    private final ModelMapper modelMapper;

    public PictureServiceImpl(PictureRepo pictureRepo, ModelMapper modelMapper) {
        this.pictureRepo = pictureRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<String> findAllPics() {
        return pictureRepo.findAllPics();
    }
}

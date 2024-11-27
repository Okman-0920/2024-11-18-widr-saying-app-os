package org.example.domain.domain.wiseSaying.service;

import org.example.domain.domain.wiseSaying.entity.WiseSaying;
import org.example.domain.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying add(String author, String content) {

        WiseSaying wiseSaying = new WiseSaying(0, author, content);
        wiseSayingRepository.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public boolean removeById(int id) {
        return wiseSayingRepository.removeById(id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingRepository.findById();
    }

    public void modify(WiseSaying wiseSaying, String author, String content) {
        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);

        wiseSayingRepository.modify(wiseSaying);
    }

    public void removeAll() {
        wiseSayingRepository.removeAll();
    }
}

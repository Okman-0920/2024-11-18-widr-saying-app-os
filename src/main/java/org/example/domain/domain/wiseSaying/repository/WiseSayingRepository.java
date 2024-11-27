package org.example.domain.domain.wiseSaying.repository;

import org.example.domain.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingRepository {
    private final List<WiseSaying> wiseSayings;
    private int id;

    public WiseSayingRepository() {
        this.wiseSayings = new ArrayList<>();
        this.id = 0;
    }

    public void add(WiseSaying wiseSaying) {
        wiseSaying.setId(++id);
        wiseSayings.add(wiseSaying);
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean removeById(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public Optional<WiseSaying> findById() {
        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst();
    }

    public void removeAll() {
        wiseSayings.clear();
        id = 0;
    }

    public void modify(WiseSaying wiseSaying) {
        //현재는 메모리에 저장되기 때문에 여기서 딱히 할일은 없다
    }
}

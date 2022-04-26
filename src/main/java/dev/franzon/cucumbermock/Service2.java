package dev.franzon.cucumbermock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Service2 {

    private final Service3 service3;

    public String execute() {
        return service3.execute() + this.getClass().getSimpleName();
    }
}

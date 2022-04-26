package dev.franzon.cucumbermock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Service1 {

    private final Service2 service2;

    public String execute() {
        return service2.execute() + this.getClass().getSimpleName();
    }
}

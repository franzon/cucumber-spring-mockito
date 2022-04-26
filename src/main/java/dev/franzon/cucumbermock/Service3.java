package dev.franzon.cucumbermock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Service3 {
    public String execute() {
        return this.getClass().getSimpleName();
    }
}

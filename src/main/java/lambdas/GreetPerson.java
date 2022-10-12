package lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GreetPerson {
    String greeting;
    StringFunction type;
}

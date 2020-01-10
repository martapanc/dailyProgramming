package AoC2019.fourteen;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
class FuelProduction {
    private long oreNeeded;
    private List<Chemical> waste;
}

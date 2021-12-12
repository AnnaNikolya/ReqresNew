package object;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.ArrayList;


@Data
public class VacanciesList {
    ArrayList<Vacancy> items;
}

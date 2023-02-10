package cezary.test.json;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("Winners")
public class WinnersGui extends VerticalLayout {


    @Autowired
    public WinnersGui(Lists outPutWinnersList) {
        Grid<OutputWinners> grid = new Grid<>(OutputWinners.class);
        grid.setItems(outPutWinnersList.getOutputWinnersList());
        add(grid);

    }
}

package cezary.test.json;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("Competitor")
public class CompetitorGui extends VerticalLayout {


    @Autowired
    public CompetitorGui(Lists lists) {
        VirtualList<String> virtualList = new VirtualList<>();
        virtualList.setItems(lists.getCompetitorsList());
        add(virtualList);

    }

}

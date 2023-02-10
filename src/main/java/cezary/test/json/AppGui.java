package cezary.test.json;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Route("home")
public class AppGui extends VerticalLayout {
    @Autowired
    public AppGui(Lists lists) throws IOException {
        VerticalLayout layout = new VerticalLayout();
        layout.add("GIVE NUMBER OF TEAMS");
        IntegerField integerField = new IntegerField();
        integerField.setLabel("NR OF TEAMS");
        integerField.setHelperText("Max " + Main.objectAssociation().size() + " teams");
        integerField.setMin(0);
        integerField.setMax(Main.objectAssociation().size());
        integerField.setValue(0);
        integerField.setStepButtonsVisible(true);
        Notification notificationWinners = new Notification();

        Notification notificationCompetitors = new Notification("LIST OF COMPETITORS COMPILED", 3000);
        Button primaryButton = new Button("SEND");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        primaryButton.addClickListener(buttonClickEvent -> {
            try {
                lists.outputWinnersList = Main.displayWinners(Main.objectAssociation(), integerField.getValue());
                notificationWinners.add("LIST COMPILED  " +lists.outputWinnersList.size()+" TEAMS FOUND");
                notificationWinners.open();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Button competitorsButton = new Button("GET COMPETITORS");
        competitorsButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        competitorsButton.addClickListener(buttonClickEvent -> {
            lists.competitorsList = Main.uniqueListOfCompetitors();
            notificationCompetitors.open();
        });


        add(layout, integerField, primaryButton, notificationWinners, competitorsButton, notificationCompetitors);
    }
}

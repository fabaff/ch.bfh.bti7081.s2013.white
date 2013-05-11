package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.model.Patient;
import ch.bfh.ti.soed.white.mhc_pms.model.PmsDataContainer;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MhcPmsMainUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		PmsDataContainer<Patient> patContainer = new PmsDataContainer<>(Patient.class);
		Table patTable = new Table();
		BeanItem bean = new BeanItem<Patient>(new Patient());
		FieldGroup binder = new FieldGroup(bean);
		
		try {
			binder.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		patTable.setContainerDataSource(patContainer);
		patTable.setSelectable(true);
		patTable.setImmediate(true);
		
		//patContainer.commit();
		this.setContent(patTable);
		
//		final VerticalLayout layout = new VerticalLayout();
//		layout.setMargin(true);
//		setContent(layout);
//
//		Button button = new Button("Click Me");
//		button.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//				layout.addComponent(new Label("Thank you for clicking"));
//			}
//		});
//		layout.addComponent(button);
//		Window main = new Window("Hello Window");
//		this.addWindow(main);
	}

}

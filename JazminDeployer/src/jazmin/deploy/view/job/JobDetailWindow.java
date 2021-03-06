/**
 * 
 */
package jazmin.deploy.view.job;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

import jazmin.deploy.domain.MachineJob;
import jazmin.deploy.ui.StaticBeanForm;

/**
 * @author yama
 * 6 Jan, 2015
 */
@SuppressWarnings("serial")
public class JobDetailWindow extends Window{
	//
	public JobDetailWindow(MachineJob app) {
        Responsive.makeResponsive(this);
        setCaption(app.id+" information");
        setWidth("600px");
        center();
        setCloseShortcut(KeyCode.ESCAPE, null);
        setResizable(true);
        setClosable(true);
        setHeight(90.0f, Unit.PERCENTAGE);
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        setContent(content);
        StaticBeanForm<MachineJob>beanForm=new StaticBeanForm<MachineJob>(
        		app, 1);
        beanForm.setSizeFull();
        content.addComponent(beanForm);
        content.setExpandRatio(beanForm, 1f);
        //
        HorizontalLayout footer = new HorizontalLayout();
        footer.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
        footer.setWidth(100.0f, Unit.PERCENTAGE);

        Button ok = new Button("Close");
        ok.addStyleName(ValoTheme.BUTTON_SMALL);
        ok.addStyleName(ValoTheme.BUTTON_PRIMARY);
        ok.addClickListener(e->close());
        ok.focus();
        footer.addComponent(ok);
        footer.setComponentAlignment(ok, Alignment.TOP_RIGHT);
        content.addComponent(footer);
    }

}

package de.urszeidler.shr5.ecp.editor.pages;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import de.urszeidler.eclipse.shr5.AbstraktGegenstand;
import de.urszeidler.eclipse.shr5.Gegenstand;
import de.urszeidler.eclipse.shr5.Kleidung;
import de.urszeidler.eclipse.shr5.Shr5Factory;
import de.urszeidler.eclipse.shr5.Shr5Package;
import de.urszeidler.eclipse.shr5.util.AdapterFactoryUtil;
import de.urszeidler.emf.commons.ui.util.EmfFormBuilder.ReferenceManager;
import de.urszeidler.shr5.ecp.editor.widgets.BeschreibbarWidget;

/**
 * Manages {@link Gegenstand} and {@link Kleidung}.
 * @author urs
 *
 */
public class GegenstandPage extends AbstractShr5Page<AbstraktGegenstand> {
	private AbstraktGegenstand object;
	private EditingDomain editingDomain;

	private DataBindingContext m_bindingContext;

	/**
	 * Create the form page.
	 * 
	 * @param id
	 * @param title
	 */
	public GegenstandPage(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * 
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public GegenstandPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		this.object = Shr5Factory.eINSTANCE.createGegenstand();
	}

	public GegenstandPage(FormEditor editor, String id, String title, AbstraktGegenstand object, EditingDomain editingDomain,
			ReferenceManager manager) {
		super(editor, id, title, manager);
		this.object = object;
		this.editingDomain = editingDomain;

	}

	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText(AdapterFactoryUtil.getInstance().getLabelProvider().getText(object));
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new GridLayout(1, false));

		BeschreibbarWidget beschreibbarWidget = new BeschreibbarWidget(managedForm.getForm().getBody(), SWT.NONE, object, toolkit);
		GridData gd_beschreibbarWidget = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_beschreibbarWidget.widthHint = 0;
		gd_beschreibbarWidget.heightHint = 0;
		beschreibbarWidget.setLayoutData(gd_beschreibbarWidget);
		managedForm.getToolkit().adapt(beschreibbarWidget);
		managedForm.getToolkit().paintBordersFor(beschreibbarWidget);

		Group grpGegenstand = new Group(managedForm.getForm().getBody(), SWT.NONE);
		grpGegenstand.setLayout(new GridLayout(6, false));
		grpGegenstand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(grpGegenstand);
		managedForm.getToolkit().paintBordersFor(grpGegenstand);

		Composite composite = new Composite(managedForm.getForm().getBody(), SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);

		Group grpWert = new Group(composite, SWT.NONE);
		grpWert.setText("Wert");
		managedForm.getToolkit().adapt(grpWert);
		managedForm.getToolkit().paintBordersFor(grpWert);
		grpWert.setLayout(new GridLayout(6, false));

		Group grpQuelle = new Group(composite, SWT.NONE);
		grpQuelle.setText("Quelle");
		managedForm.getToolkit().adapt(grpQuelle);
		managedForm.getToolkit().paintBordersFor(grpQuelle);
		grpQuelle.setLayout(new GridLayout(6, false));

		m_bindingContext = initDataBindings();

		createFormBuilder(managedForm);

		if (object instanceof Gegenstand) {
			grpGegenstand.setText("Gegenstand");
			emfFormBuilder.addTextEntry("Kategorie", Shr5Package.Literals.GEGENSTAND__KATEGORIE, grpGegenstand);
			emfFormBuilder.addTextEntry("Stufe", Shr5Package.Literals.GEGENSTAND__STUFE, grpGegenstand);
		} else if (object instanceof Kleidung) {
			grpGegenstand.setText("Rüstung");
			emfFormBuilder.addTextEntry("Panzer Wert", Shr5Package.Literals.KLEIDUNG__RUESTUNG, grpGegenstand);

		}
		emfFormBuilder.addTextEntry("Wert", Shr5Package.Literals.GELD_WERT__WERT, grpWert);
		emfFormBuilder.addTextEntry("Verfügbarkeit", Shr5Package.Literals.GELD_WERT__VERFUEGBARKEIT, grpWert);

		emfFormBuilder.addTextEntry("Source", Shr5Package.Literals.QUELLE__SRC_BOOK, grpQuelle);
		emfFormBuilder.addTextEntry("Page", Shr5Package.Literals.QUELLE__PAGE, grpQuelle);

		emfFormBuilder.buildinComposite(m_bindingContext, managedForm.getForm().getBody(), object);
		managedForm.reflow(true);
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}

	@Override
	protected EditingDomain getEditingDomain() {
		return editingDomain;
	}
}
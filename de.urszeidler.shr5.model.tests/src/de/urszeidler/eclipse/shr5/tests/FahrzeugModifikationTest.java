/**
 */
package de.urszeidler.eclipse.shr5.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.urszeidler.eclipse.shr5.FahrzeugModifikation;
import de.urszeidler.eclipse.shr5.Shr5Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Fahrzeug Modifikation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FahrzeugModifikationTest extends TestCase {

	/**
     * The fixture for this Fahrzeug Modifikation test case.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FahrzeugModifikation fixture = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static void main(String[] args) {
        TestRunner.run(FahrzeugModifikationTest.class);
    }

	/**
     * Constructs a new Fahrzeug Modifikation test case with the given name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FahrzeugModifikationTest(String name) {
        super(name);
    }

	/**
     * Sets the fixture for this Fahrzeug Modifikation test case.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void setFixture(FahrzeugModifikation fixture) {
        this.fixture = fixture;
    }

	/**
     * Returns the fixture for this Fahrzeug Modifikation test case.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FahrzeugModifikation getFixture() {
        return fixture;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
	@Override
	protected void setUp() throws Exception {
        setFixture(Shr5Factory.eINSTANCE.createFahrzeugModifikation());
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
	@Override
	protected void tearDown() throws Exception {
        setFixture(null);
    }

} //FahrzeugModifikationTest

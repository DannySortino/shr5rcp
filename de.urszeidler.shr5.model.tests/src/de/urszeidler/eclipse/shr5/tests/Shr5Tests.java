/**
 */
package de.urszeidler.eclipse.shr5.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>shr5</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class Shr5Tests extends TestSuite {

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static void main(String[] args) {
        TestRunner.run(suite());
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Test suite() {
        TestSuite suite = new Shr5Tests("shr5 Tests");
        suite.addTestSuite(MudanPersonaTest.class);
        suite.addTestSuite(KiAdeptTest.class);
        suite.addTestSuite(MagierTest.class);
        suite.addTestSuite(MysticAdeptTest.class);
        suite.addTestSuite(AspektMagierTest.class);
        suite.addTestSuite(TechnomancerTest.class);
        suite.addTestSuite(SpriteTest.class);
        return suite;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Shr5Tests(String name) {
        super(name);
    }

} //Shr5Tests

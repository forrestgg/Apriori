/*
 * Copyright 2017 Michael Rapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package de.mrapp.apriori;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Tests the functionality of the class {@link AssociationRule}.
 *
 * @author Michael Rapp
 */
public class AssociationRuleTest {

    /**
     * Tests, if all class members are set correctly by the constructor.
     */
    @Test
    public final void testConstructor() {
        Set<NamedItem> body = new HashSet<>();
        body.add(new NamedItem("a"));
        body.add(new NamedItem("b"));
        Set<NamedItem> head = new HashSet<>();
        head.add(new NamedItem("c"));
        head.add(new NamedItem("d"));
        double support = 0.5;
        double confidence = 0.4;
        double lift = 0.3;
        double leverage = 0.2;
        AssociationRule<NamedItem> associationRule = new AssociationRule<>(body, head, support,
                confidence, lift, leverage);
        assertEquals(body, associationRule.getBody());
        assertEquals(head, associationRule.getHead());
        assertEquals(support, associationRule.getSupport(), 0);
        assertEquals(confidence, associationRule.getConfidence(), 0);
        assertEquals(lift, associationRule.getLift(), 0);
        assertEquals(leverage, associationRule.getLeverage(), 0);
    }

    /**
     * Tests the functionality of the toString-method.
     */
    @Test
    public final void testToString() {
        Set<NamedItem> body = new HashSet<>();
        body.add(new NamedItem("a"));
        body.add(new NamedItem("b"));
        Set<NamedItem> head = new HashSet<>();
        head.add(new NamedItem("c"));
        head.add(new NamedItem("d"));
        AssociationRule<NamedItem> associationRule = new AssociationRule<>(body, head, 0.5, 0.4,
                0.3, 0.2);
        assertEquals("[a, b] -> [c, d]", associationRule.toString());
    }

    /**
     * Tests the functionality of the hashCode-method.
     */
    @Test
    public final void testHashCode() {
        Set<NamedItem> body1 = new HashSet<>();
        body1.add(new NamedItem("a"));
        Set<NamedItem> body2 = new HashSet<>();
        body2.add(new NamedItem("c"));
        Set<NamedItem> head1 = new HashSet<>();
        head1.add(new NamedItem("b"));
        Set<NamedItem> head2 = new HashSet<>();
        head2.add(new NamedItem("d"));
        AssociationRule<NamedItem> associationRule1 = new AssociationRule<>(body1, head1, 0.5, 0.5,
                0.5, 0.5);
        AssociationRule<NamedItem> associationRule2 = new AssociationRule<>(body1, head1, 0.5, 0.5,
                0.5, 0.5);
        assertEquals(associationRule1.hashCode(), associationRule1.hashCode());
        assertEquals(associationRule1.hashCode(), associationRule2.hashCode());
        associationRule2 = new AssociationRule<>(body2, head1, 0.5, 0.5, 0.5, 0.5);
        assertNotEquals(associationRule1.hashCode(), associationRule2.hashCode());
        associationRule2 = new AssociationRule<>(body1, head2, 0.5, 0.5, 0.5, 0.5);
        assertNotEquals(associationRule1.hashCode(), associationRule2.hashCode());
        associationRule2 = new AssociationRule<>(body1, head1, 0.6, 0.5, 0.5, 0.5);
        assertNotEquals(associationRule1.hashCode(), associationRule2.hashCode());
        associationRule2 = new AssociationRule<>(body1, head1, 0.5, 0.6, 0.5, 0.5);
        assertNotEquals(associationRule1.hashCode(), associationRule2.hashCode());
        associationRule2 = new AssociationRule<>(body1, head1, 0.5, 0.5, 0.6, 0.5);
        assertNotEquals(associationRule1.hashCode(), associationRule2.hashCode());
        associationRule2 = new AssociationRule<>(body1, head1, 0.5, 0.5, 0.5, 0.6);
        assertNotEquals(associationRule1.hashCode(), associationRule2.hashCode());
    }

    /**
     * Tests the functionality of the equals-method.
     */
    @Test
    public final void testEquals() {
        Set<NamedItem> body1 = new HashSet<>();
        body1.add(new NamedItem("a"));
        Set<NamedItem> body2 = new HashSet<>();
        body2.add(new NamedItem("c"));
        Set<NamedItem> head1 = new HashSet<>();
        head1.add(new NamedItem("b"));
        Set<NamedItem> head2 = new HashSet<>();
        head2.add(new NamedItem("d"));
        AssociationRule associationRule1 = new AssociationRule<>(body1, head1, 0.5, 0.5, 0.5, 0.5);
        AssociationRule associationRule2 = new AssociationRule<>(body1, head1, 0.5, 0.5, 0.5, 0.5);
        assertFalse(associationRule1.equals(null));
        assertFalse(associationRule1.equals(new Object()));
        assertTrue(associationRule1.equals(associationRule1));
        assertTrue(associationRule1.equals(associationRule2));
        associationRule2 = new AssociationRule<>(body2, head1, 0.5, 0.5, 0.5, 0.5);
        assertFalse(associationRule1.equals(associationRule2));
        associationRule2 = new AssociationRule<>(body1, head2, 0.5, 0.5, 0.5, 0.5);
        assertFalse(associationRule1.equals(associationRule2));
        associationRule2 = new AssociationRule<>(body1, head1, 0.6, 0.5, 0.5, 0.5);
        assertFalse(associationRule1.equals(associationRule2));
        associationRule2 = new AssociationRule<>(body1, head1, 0.5, 0.6, 0.5, 0.5);
        assertFalse(associationRule1.equals(associationRule2));
        associationRule2 = new AssociationRule<>(body1, head1, 0.5, 0.5, 0.6, 0.5);
        assertFalse(associationRule1.equals(associationRule2));
        associationRule2 = new AssociationRule<>(body1, head1, 0.5, 0.5, 0.5, 0.6);
        assertFalse(associationRule1.equals(associationRule2));
    }

}
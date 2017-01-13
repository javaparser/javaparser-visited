package org.javaparser.examples;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ModifyingVisitorExampleTest {

    @Test
    public void shouldNotAddUnderscores(){
        assertThat(ModifyingVisitorExample.formatWithUnderscores("100"), is("100"));
    }

    @Test
    public void shouldFormatNumberInThousands(){
        assertThat(ModifyingVisitorExample.formatWithUnderscores("2000"), is("2_000"));
    }

    @Test
    public void shouldFormatNumberInMillions(){
        assertThat(ModifyingVisitorExample.formatWithUnderscores("3000000"), is("3_000_000"));
    }

    @Test
    public void shouldFormatNumberInBillions(){
        assertThat(ModifyingVisitorExample.formatWithUnderscores("4000000000"), is("4_000_000_000"));
    }

    @Test
    public void shouldRemoveExistingUnderscores(){
        assertThat(ModifyingVisitorExample.formatWithUnderscores("1_0_0_0"), is("1_000"));
    }

    @Test
    public void shouldWorkForNegativeValueInThousands(){
        assertThat(ModifyingVisitorExample.formatWithUnderscores("-1000"), is("-1_000"));
    }

    @Test
    public void shouldWorkForNegativeValueInHundreds(){
        assertThat(ModifyingVisitorExample.formatWithUnderscores("-100"), is("-100"));
    }

}
package org.javaparser.examples.chapter2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ModifyingVisitorExampleTest {

    @Test
    public void shouldNotAddUnderscores(){
        assertThat(ModifyingVisitorComplete.formatWithUnderscores("100"), is("100"));
    }

    @Test
    public void shouldFormatNumberInThousands(){
        assertThat(ModifyingVisitorComplete.formatWithUnderscores("2000"), is("2_000"));
    }

    @Test
    public void shouldFormatNumberInMillions(){
        assertThat(ModifyingVisitorComplete.formatWithUnderscores("3000000"), is("3_000_000"));
    }

    @Test
    public void shouldFormatNumberInBillions(){
        assertThat(ModifyingVisitorComplete.formatWithUnderscores("4000000000"), is("4_000_000_000"));
    }

    @Test
    public void shouldRemoveExistingUnderscores(){
        assertThat(ModifyingVisitorComplete.formatWithUnderscores("1_0_0_0"), is("1_000"));
    }

    @Test
    public void shouldWorkForNegativeValueInThousands(){
        assertThat(ModifyingVisitorComplete.formatWithUnderscores("-1000"), is("-1_000"));
    }

    @Test
    public void shouldWorkForNegativeValueInHundreds(){
        assertThat(ModifyingVisitorComplete.formatWithUnderscores("-100"), is("-100"));
    }

}
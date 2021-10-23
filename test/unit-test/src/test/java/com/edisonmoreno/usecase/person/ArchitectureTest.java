package com.edisonmoreno.usecase.person;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

class ArchitectureTest {
    @Test
    void layered_architecture_rule_OK() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.edisonmoreno");

        Architectures.layeredArchitecture()
                .layer("com.edisonmoreno.model..").definedBy("..model..")
                .layer("com.edisonmoreno.usecase..").definedBy("..usecase..")
                .check(importedClasses);
    }

    @Test
    void layered_architecture_rule_FAILED() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.edisonmoreno");

        Architectures.layeredArchitecture()
                .layer("com.edisonmoreno.model..").definedBy("..MODEL..")
                .layer("com.edisonmoreno.usecase..").definedBy("..USECASE..")
                .check(importedClasses);

    }

    @Test
    void some_architecture_rule_OK() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.edisonmoreno");

        ArchRule myRule = classes()
                .that().resideInAPackage("..usecase..")
                .should().haveSimpleNameNotContaining("PersonASUseCase");


        myRule.check(importedClasses);
    }

    @Test
    void some_architecture_rule_FAILED() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.edisonmoreno");

        ArchRule myRule = classes()
                .that().resideInAPackage("..usecase..")
                .should().haveSimpleNameNotContaining("PersonUseCase");


        myRule.check(importedClasses);
    }

}

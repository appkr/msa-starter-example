package dev.appkr.example;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

public class HexagonalTest {

  static final JavaClasses importedClasses = new ClassFileImporter()
      .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
      .importPackages("dev.appkr.example");

  @Test
  public void domainShouldNotDependOnAnyOtherPackages() {
    noClasses()
        .that()
        .resideInAnyPackage("dev.appkr.example.domain..")
        .should()
        .dependOnClassesThat()
        .resideInAnyPackage("dev.appkr.example.application..", "dev.appkr.example.adapter..")
        .because("Domain should not depend on any other packages")
        .check(importedClasses);
  }

  @Test
  public void applicationShouldNotDependOnAdapter() {
    noClasses()
        .that()
        .resideInAnyPackage("dev.appkr.example.application..")
        .should()
        .dependOnClassesThat()
        .resideInAnyPackage("dev.appkr.example.adapter..")
        .because("Application should not depend on any adapter packages")
        .check(importedClasses);
  }
}

package org.javaparser.examples.chapter5;

import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

public class UsingTypeSolver {

    private static void showReferenceTypeDeclaration(ResolvedReferenceTypeDeclaration resolvedReferenceTypeDeclaration){

        System.out.printf("== %s ==%n", resolvedReferenceTypeDeclaration
                .getQualifiedName());
        System.out.println(" fields:");
        resolvedReferenceTypeDeclaration.getAllFields()
                .forEach(f -> System.out.printf("    %s %s%n", f.getType(),
                        f.getName()));
        System.out.println(" methods:");
        resolvedReferenceTypeDeclaration.getAllMethods()
                .forEach(m -> System.out.printf("    %s%n",
                        m.getQualifiedSignature()));
        System.out.println();
    }

    public static void main(String[] args) {
        TypeSolver typeSolver = new ReflectionTypeSolver();

        showReferenceTypeDeclaration(typeSolver.solveType("java.lang.Object"));
        showReferenceTypeDeclaration(typeSolver.solveType("java.lang.String"));
        showReferenceTypeDeclaration(typeSolver.solveType("java.util.List"));
    }
}
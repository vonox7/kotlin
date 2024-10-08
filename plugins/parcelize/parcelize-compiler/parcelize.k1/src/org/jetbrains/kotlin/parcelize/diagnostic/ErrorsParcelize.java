/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.parcelize.diagnostic;

import com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.diagnostics.DiagnosticFactory0;
import org.jetbrains.kotlin.diagnostics.DiagnosticFactory1;
import org.jetbrains.kotlin.diagnostics.DiagnosticFactory2;
import org.jetbrains.kotlin.diagnostics.Errors;
import org.jetbrains.kotlin.psi.KtClassOrObject;
import org.jetbrains.kotlin.types.KotlinType;

import static org.jetbrains.kotlin.diagnostics.Severity.ERROR;
import static org.jetbrains.kotlin.diagnostics.Severity.WARNING;

public interface ErrorsParcelize {
    DiagnosticFactory0<PsiElement> PARCELABLE_SHOULD_BE_CLASS = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> PARCELABLE_DELEGATE_IS_NOT_ALLOWED = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> PARCELABLE_SHOULD_NOT_BE_ENUM_CLASS = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> PARCELABLE_SHOULD_BE_INSTANTIABLE = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> PARCELABLE_CANT_BE_INNER_CLASS = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> PARCELABLE_CANT_BE_LOCAL_CLASS = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> NO_PARCELABLE_SUPERTYPE = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> PARCELABLE_SHOULD_HAVE_PRIMARY_CONSTRUCTOR = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> PARCELABLE_PRIMARY_CONSTRUCTOR_IS_EMPTY = DiagnosticFactory0.create(WARNING);
    DiagnosticFactory0<PsiElement> PARCELABLE_CONSTRUCTOR_PARAMETER_SHOULD_BE_VAL_OR_VAR = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> PROPERTY_WONT_BE_SERIALIZED = DiagnosticFactory0.create(WARNING);
    DiagnosticFactory0<PsiElement> OVERRIDING_WRITE_TO_PARCEL_IS_NOT_ALLOWED = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> CREATOR_DEFINITION_IS_NOT_ALLOWED = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> PARCELABLE_TYPE_NOT_SUPPORTED = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory1<PsiElement, KotlinType> PARCELABLE_TYPE_CONTAINS_NOT_SUPPORTED = DiagnosticFactory1.create(ERROR);
    DiagnosticFactory0<PsiElement> PARCELER_SHOULD_BE_OBJECT = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory2<PsiElement, KotlinType, KotlinType> PARCELER_TYPE_INCOMPATIBLE = DiagnosticFactory2.create(ERROR);
    DiagnosticFactory0<PsiElement> DUPLICATING_TYPE_PARCELERS = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory1<PsiElement, KtClassOrObject> REDUNDANT_TYPE_PARCELER = DiagnosticFactory1.create(WARNING);
    DiagnosticFactory1<PsiElement, KtClassOrObject> CLASS_SHOULD_BE_PARCELIZE = DiagnosticFactory1.create(ERROR);
    DiagnosticFactory0<PsiElement> FORBIDDEN_DEPRECATED_ANNOTATION = DiagnosticFactory0.create(ERROR);
    DiagnosticFactory0<PsiElement> DEPRECATED_ANNOTATION = DiagnosticFactory0.create(WARNING);
    DiagnosticFactory0<PsiElement> DEPRECATED_PARCELER = DiagnosticFactory0.create(ERROR);

    DiagnosticFactory0<PsiElement> INAPPLICABLE_IGNORED_ON_PARCEL = DiagnosticFactory0.create(WARNING);
    DiagnosticFactory0<PsiElement> INAPPLICABLE_IGNORED_ON_PARCEL_CONSTRUCTOR_PROPERTY = DiagnosticFactory0.create(WARNING);

    DiagnosticFactory0<PsiElement> VALUE_PARAMETER_USED_IN_CLASS_BODY = DiagnosticFactory0.create(ERROR);

    @SuppressWarnings("UnusedDeclaration")
    Object _initializer = new Object() {
        {
            Errors.Initializer.initializeFactoryNamesAndDefaultErrorMessages(ErrorsParcelize.class, DefaultErrorMessagesParcelize.INSTANCE);
        }
    };

}

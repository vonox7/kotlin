/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

@file:OptIn(KaAnalysisApiInternals::class)

package org.jetbrains.kotlin.analysis.api

import com.intellij.psi.PsiFile
import org.jetbrains.kotlin.analysis.api.session.KaSessionProvider
import org.jetbrains.kotlin.analysis.project.structure.DanglingFileResolutionMode
import org.jetbrains.kotlin.analysis.project.structure.KtModule
import org.jetbrains.kotlin.analysis.project.structure.KtModuleStructureInternals
import org.jetbrains.kotlin.analysis.project.structure.withDanglingFileResolutionMode
import org.jetbrains.kotlin.psi.KtElement

/**
 * Executes the given [action] in a [KaSession] context.
 *
 * The project will be analyzed from the perspective of [useSiteKtElement]'s module, also called the use-site module.
 *
 * @see KaSession
 */
public inline fun <R> analyze(
    useSiteKtElement: KtElement,
    action: KaSession.() -> R
): R =
    KaSessionProvider.getInstance(useSiteKtElement.project)
        .analyze(useSiteKtElement, action)

/**
 * Executes the given [action] in a [KaSession] context.
 *
 * The project will be analyzed from the perspective of the given [useSiteKtModule].
 *
 * @see KaSession
 */
public inline fun <R> analyze(
    useSiteKtModule: KtModule,
    crossinline action: KaSession.() -> R
): R {
    val sessionProvider = KaSessionProvider.getInstance(useSiteKtModule.project)
    return sessionProvider.analyze(useSiteKtModule, action)
}

/**
 * Executes the given [action] in a [KaSession] context.
 * Depending on the passed [resolutionMode], declarations inside a file copy will be treated in a specific way.
 *
 * Note that the [useSiteKtElement] must be inside a dangling file copy.
 * Specifically, [PsiFile.getOriginalFile] must point to the copy source.
 *
 * The project will be analyzed from the perspective of [useSiteKtElement]'s module, also called the use-site module.
 */
@OptIn(KtModuleStructureInternals::class)
public inline fun <R> analyzeCopy(
    useSiteKtElement: KtElement,
    resolutionMode: DanglingFileResolutionMode,
    crossinline action: KaSession.() -> R,
): R {
    val containingFile = useSiteKtElement.containingKtFile
    return withDanglingFileResolutionMode(containingFile, resolutionMode) {
        analyze(containingFile, action)
    }
}
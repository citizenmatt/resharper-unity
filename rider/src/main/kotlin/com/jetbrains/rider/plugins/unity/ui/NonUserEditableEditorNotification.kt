package com.jetbrains.rider.plugins.unity.ui

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotificationPanel
import com.intellij.ui.EditorNotifications
import com.jetbrains.rider.isUnityProject
import com.jetbrains.rider.plugins.unity.util.isNonEditableUnityFile

class NonUserEditableEditorNotification : EditorNotifications.Provider<EditorNotificationPanel>(), DumbAware {

    companion object {
        val KEY = Key.create<EditorNotificationPanel>("non-user.editable.source.file.editing.notification.panel")
    }

    override fun getKey(): Key<EditorNotificationPanel> = KEY

    override fun createNotificationPanel(file: VirtualFile, fileEditor: FileEditor, project: Project): EditorNotificationPanel? {
       if (!project.isUnityProject() || !isNonEditableUnityFile(file)) {
            return null
        }

        val panel = EditorNotificationPanel()
        panel.setText("This file is internal to Unity and should not be edited manually.")
        return panel
    }
}


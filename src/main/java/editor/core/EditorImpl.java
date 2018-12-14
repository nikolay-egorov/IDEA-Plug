package editor.core;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import editor.EditorInterface;

import javax.swing.*;

public class EditorImpl implements EditorInterface {

    private VirtualFile file;
    private Project project;
    private  boolean isDisposed;

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public JComponent getJComponent() {
        return null;
    }

    @Override
    public JComponent getContentComponent() {
        return null;
    }

    @Override
    public VirtualFile getFile() {
        return file;
    }

    @Override
    public void dispose() {
        isDisposed=true;
    }
}

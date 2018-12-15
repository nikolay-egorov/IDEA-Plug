package editCore;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import editCore.GUI.MainUI;

import javax.swing.*;

public class EditorInterfaceImpl implements EditorInterface {

    private VirtualFile file;
    private Project project;
    private  boolean isDisposed;
    private final MainUI editGUI;


    public EditorInterfaceImpl(Project project, VirtualFile file) {
        this.file = file;
        this.project = project;

        //UI?
        editGUI=new MainUI(this);
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public JComponent getJComponent() { return editGUI; }

    @Override
    public JComponent getContentComponent() {
        return editGUI.getDiagramComponent();
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

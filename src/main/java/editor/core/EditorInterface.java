package editor.core;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import javax.swing.*;

public interface  EditorInterface extends Disposable {


    Project getProject();

    JComponent getJComponent();

    JComponent getContentComponent();

    VirtualFile getFile();
}

package editor;

import com.intellij.ide.FileEditorProvider;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class CustomFileProvider implements FileEditorProvider {


/*    //@NotNull
    @Override
    public FileEditor openFileEditor(Project project,  VirtualFile virtualFile) {
        return null;
    }

    @Override
    public String getEditorType(){
        return  null;
    }*/

    @Override
    public FileEditor openFileEditor() {
        return null;
    }

 
}

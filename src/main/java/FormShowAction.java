import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import static icons.UIDesignerNewIcons.ToolWindow;

public class FormShowAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        BrowserUtil.browse("https://stackoverflow.com/questions/ask");
        MainViewer viewer=new MainViewer();


    }
}

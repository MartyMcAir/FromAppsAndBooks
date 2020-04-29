package b_BigTusks.z_Html_Editor_3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

// в меню: подстрочный
public class SubscriptAction extends StyledEditorKit.StyledTextAction {
    public SubscriptAction() {
//    public SubscriptAction(String nm) {
//        super(nm); // в условиях об это ничего не было написано
        super(StyleConstants.Subscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Изучи реализ StrikeThroughAction, которую ты получил вместе с заданием и реализ аналогич образом
        JEditorPane editor = getEditor(e);   // получаем эдитор из поведения
        if (editor != null) {
            // StyledEditorKit - (модель фабрики классов) инстр стилей присваив интерфейсу MutableAttributes
            // getInputAttributes() - возвращает из StyledEditorKit интерфейс MutableAttributeSet
            // Mutable - означает изменеямое (immutable - неизменяемое как String)
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            // Изменение стиля части текста
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            // Создание стилей
            StyleConstants.setSubscript(simpleAttributeSet, !StyleConstants.isSubscript(mutableAttributeSet));
            // 3й параметр если true удаляет inPut..Attribute полученный через getInputAttributes()
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}

package b_BigTusks.z_Html_Editor_3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class z_StrikeThroughAction_Descriptions extends StyledEditorKit.StyledTextAction {
    // Изучи реализацию класса StrikeThroughAction, которую ты получил вместе с заданием и реализуй аналогичным образом классы:
//12.3.1. SubscriptAction _ 12.3.2. SuperscriptAction
    // это реализация для подстрочный надстрочный и зачеркнутый шрифты

    // Если хотите исправить эксепшен во вкладке Текст , то вам нужно пройти по такому пути: View class ->
    // initEditor() method и добавить такую строку :
    // plainTextPane.setContentType("text/html");
    public z_StrikeThroughAction_Descriptions() {
        super(StyleConstants.StrikeThrough.toString());
    }

    public void actionPerformed(ActionEvent actionEvent) {
        // получаем экземпляр инструмента для отображения на экране текста любого формата.
        // Через наследуемый метод с класса StyledTextAction
        JEditorPane editor = getEditor(actionEvent);   // получаем эдитор из поведения
        if (editor != null) {
            // StyledEditorKit - (модель фабрики классов) инстр стилей присваив интерфейсу MutableAttributes
            // getInputAttributes() - возвращает из StyledEditorKit интерфейс MutableAttributeSet
            // Mutable - означает изменеямое (immutable - неизменяемое как String)
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            // Изменение стиля части текста
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            // Создание стилей
            StyleConstants.setStrikeThrough(simpleAttributeSet, !StyleConstants.isStrikeThrough(mutableAttributeSet));
            // 3й параметр если true удаляет inPut..Attribute полученный через getInputAttributes()
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }

    // Не понял, как работает actionPerformed - сделал просто по аналогии. Слишком много новых неизвестных классов,
    // интерфейсов и методов, чтобы в этом разобраться. Возможно, позже к этому вернусь.

    // From Comments
    public void actionPerformed2(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);   // получаем эдитор из поведения
        //получаем атрибуты текущего стиля и сохраняем в mutableAttributeSet как мару (вроде так)
        MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();

        //создаем пустое множество (HаshTable), которое имплементирует MutableAttributeSet (т.е. упрощенный вариант mutableAttributeSet)
        SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();

        //устанавливает пустому множеству атрибут Зачеркивания, если в исходном стиле не содержится атрибут Зачеркивания
        StyleConstants.setStrikeThrough(simpleAttributeSet, !StyleConstants.isStrikeThrough(mutableAttributeSet));

        //устанавливает editor'у, стиль множества, без замены существующих атрибутов.
        setCharacterAttributes(editor, simpleAttributeSet, false);
    }
}


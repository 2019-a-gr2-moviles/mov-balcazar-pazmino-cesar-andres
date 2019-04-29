package Vista
import java.awt.Color
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.event.ActionListener
import javax.swing.*

class VistaInical (titulo:String):JFrame(){
    init {
        createUI(titulo)
    }


    private fun createUI(title: String) {

        setTitle(title)


        val btnInsert = JButton("INSERT");
        val btnRead = JButton("READ");
        val btnDelete = JButton("DELETE");
        val btnUpdate = JButton("UPDATE");

       // closeBtn.addActionListener { System.exit(0) }
        //btnInsert.addActionListener { JOptionPane.showMessageDialog(null,"hola!!!"); }



        var listbtns= arrayOf<JButton>(btnInsert,btnRead,btnDelete,btnUpdate);

        val botones = listbtns.map {
            JButton(it.text).apply {
                background= Color.GRAY
                preferredSize= Dimension(60,40)
                //minimumSize = Dimension(90, 40)
                //background = it.
                isOpaque = true
            }
        }


        createLayout(botones);


        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 200)
        setLocationRelativeTo(null)
    }

    public fun createAndShowGUI() {

        val frame = VistaInical("Simple")
        frame.isVisible = true
    }


    private fun createLayout(arg: List<JComponent>) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true;
        gl.autoCreateGaps = true

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])));

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3]));







        pack();
    }


    fun action(){
        println("holaaaaaa");
    }
}
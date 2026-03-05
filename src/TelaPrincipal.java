import service.MedicamentoService;
import model.Medicamento;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private MedicamentoService medicamentoService;

    public TelaPrincipal() {
ImageIcon icon = new ImageIcon("resources/icone.png");
setIconImage(icon.getImage());
        medicamentoService = new MedicamentoService();

        setTitle("Sistema de Consulta de Medicamentos");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color top = new Color(21, 101, 192);
                Color bottom = new Color(66, 165, 245);
                GradientPaint gp = new GradientPaint(0, 0, top, 0, getHeight(), bottom);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        background.setLayout(new GridBagLayout());

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(430, 360));
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(30, 30, 30, 30));

        JLabel titulo = new JLabel("Consulta de Sintomas");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField campoSintoma = new JTextField();
        campoSintoma.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        campoSintoma.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        BotaoModerno botaoBuscar = new BotaoModerno("Buscar");
        botaoBuscar.setFocusPainted(false);
        botaoBuscar.setBackground(new Color(25, 118, 210));
        botaoBuscar.setForeground(Color.WHITE);
        botaoBuscar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botaoBuscar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));

        JTextArea areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        campoSintoma.addActionListener(e -> botaoBuscar.doClick());

        botaoBuscar.addActionListener(e -> {

            String sintoma = campoSintoma.getText();

            Medicamento medicamento = medicamentoService.buscarPorSintoma(sintoma);

            if (medicamento != null) {
                areaResultado.setText(
                        "Medicamento recomendado:\n\n" +
                        medicamento.getNome() +
                        "\n\nTomar a cada: " +
                        medicamento.getIntervaloHoras() + " horas."
                );
            } else {
                areaResultado.setText("Nenhum medicamento encontrado.");
            }
        });
        BotaoModerno botaoSair = new BotaoModerno("Sair");
       botaoSair.setFocusPainted(false);
        botaoSair.setBackground(new Color(25, 118, 210));
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setFont(new Font("Segoe UI", Font.BOLD, 16));
botaoSair.addActionListener(e -> {
    new TelaLogin().setVisible(true); 
    dispose();                        
});
        JPanel painelBotoesFinal = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        painelBotoesFinal.setOpaque(false);
        painelBotoesFinal.add(botaoBuscar);
        painelBotoesFinal.add(botaoSair);
scroll.setPreferredSize(new Dimension(Integer.MAX_VALUE, 150)); 
scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
       card.add(titulo);
card.add(Box.createRigidArea(new Dimension(0, 20)));
card.add(campoSintoma);
card.add(Box.createRigidArea(new Dimension(0, 15)));
card.add(scroll); 
card.add(Box.createRigidArea(new Dimension(0, 20)));
card.add(painelBotoesFinal);

        background.add(card);
        
        add(background);
    }
}
import service.UsuarioService;
import service.AuthService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaLogin extends JFrame {

    private UsuarioService usuarioService;
    private AuthService authService;

    public TelaLogin() {
ImageIcon icon = new ImageIcon("resources/icone.png");
setIconImage(icon.getImage());
        usuarioService = new UsuarioService();
        authService = new AuthService(usuarioService);

        setTitle("Login - Sistema de Medicamentos");
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
        card.setPreferredSize(new Dimension(350, 260));
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(30, 30, 30, 30));

        JLabel titulo = new JLabel("Acesso ao Sistema");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField campoUser = new JTextField();
        campoUser.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        campoUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        campoSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        BotaoModerno botaoLogin = new BotaoModerno("Entrar");
        BotaoModerno botaoCadastrar = new BotaoModerno("Cadastrar");
        botaoLogin.setBackground(new Color(25, 118, 210));
        botaoLogin.setForeground(Color.WHITE);
        botaoLogin.setFocusPainted(false);

        botaoCadastrar.setBackground(new Color(25, 118, 210));
        botaoCadastrar.setForeground(Color.WHITE);
        botaoCadastrar.setFocusPainted(false);

    botaoLogin.addActionListener(e -> {

    String username = campoUser.getText().trim();
    String senha = new String(campoSenha.getPassword()).trim();

    if (username.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Digite usuário e senha.");
        return;
    }

    if (authService.login(username, senha)) {
        new TelaPrincipal().setVisible(true);
        dispose();
    } else {
        JOptionPane.showMessageDialog(this,
                "Usuário ou senha inválidos.");
    }
});

      botaoCadastrar.addActionListener(e -> {

    String username = campoUser.getText().trim();
    String senha = new String(campoSenha.getPassword()).trim();

    if (username.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Usuário e senha são obrigatórios.");
        return;
    }

    usuarioService.cadastrarUsuario(username, senha);
    JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso.");
});
JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

painelBotoes.setOpaque(false);
painelBotoes.add(botaoLogin);
painelBotoes.add(botaoCadastrar);

        card.add(titulo);
        card.add(Box.createRigidArea(new Dimension(0, 20)));
        card.add(campoUser);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(campoSenha);
        card.add(Box.createRigidArea(new Dimension(0, 40)));
        card.add(painelBotoes);

        background.add(card);
        add(background);
    }
}
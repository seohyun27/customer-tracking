package main;

import javax.swing.*;
import java.awt.*;

public class ManagerMain extends JFrame {
    private JPanel mainPanel; // 주 패널
    private CardLayout cardLayout; // 패널 전환을 위한 레이아웃

    //패널 식별자 변수
    private static final String M_MAIN_PANEL = "매니저 메인 화면 패널"; //빈 화면
    private static final String ADD_OWNER_PANEL = "점주 추가 패널";


    public ManagerMain() { //생성자
        setTitle("매니저");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout 초기화
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel ownerMainPanel = createMainPanel();
        mainPanel.add(ownerMainPanel, ADD_OWNER_PANEL);

        // 점주 추가 패널 생성 및 추가
        JPanel addOwnerPanel = createAddPanel();
        mainPanel.add(addOwnerPanel, ADD_OWNER_PANEL);

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();

        //첫 번째 메뉴
        JMenu ownerMenu = new JMenu("점주 관리");
        JMenuItem ownerAdd = new JMenuItem("추가");
        JMenuItem ownerDel = new JMenuItem("삭제");
        JMenuItem ownerList = new JMenuItem("리스트 보기");

        //두 번째 메뉴
        JMenu stats = new JMenu("통계 보기");

        //세 번째 메뉴
        JMenu logout = new JMenu("통계 보기");

        // 메뉴 아이템 클릭 이벤트 추가
        ownerAdd.addActionListener(e -> cardLayout.show(mainPanel, ADD_OWNER_PANEL));
        //menuItemPassword.addActionListener(e -> cardLayout.show(mainPanel, PASSWORD_PANEL));

        // 메뉴에 항목 추가
        ownerMenu.add(ownerAdd);
        ownerMenu.add(ownerDel);
        ownerMenu.add(ownerList);

        menuBar.add(ownerMenu);
        menuBar.add(stats);
        menuBar.add(logout);

        // 메뉴바를 프레임에 추가
        setJMenuBar(menuBar);

        // 초기 화면은 매니저 메인 패널로 설정
        cardLayout.show(mainPanel, M_MAIN_PANEL);

        // 메인 패널을 프레임에 추가
        add(mainPanel);

        // 창 설정
        setSize(850, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //매니저 메인 화면 패널을 생성하는 메소드
    public JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        return panel;
    }

    //점주 추가 패널을 생성하는 메소드
    public JPanel createAddPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 설명 라벨
        JLabel titleLabel = new JLabel("추가할 점주의 아이디와 비밀번호를 생성하세요", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        // 중앙 입력창 패널
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // 아이디 라벨 및 입력창
        JLabel idLabel = new JLabel("아이디");
        idLabel.setOpaque(true);
        idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setPreferredSize(new Dimension(80, 30));

        JTextField idField = new JTextField();
        idField.setPreferredSize(new Dimension(250, 30));
        idField.setBackground(new Color(227, 232, 239));

        // 비밀번호 라벨 및 입력창
        JLabel passwordLabel = new JLabel("비밀번호");
        passwordLabel.setOpaque(true);
        passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setPreferredSize(new Dimension(80, 30));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(250, 30));
        passwordField.setBackground(new Color(227, 232, 239));

        // 아이디 필드 추가 (첫 번째 행)
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        inputPanel.add(idField, gbc);

        // 비밀번호 필드 추가 (두 번째 행)
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        inputPanel.add(passwordField, gbc);

        panel.add(inputPanel, BorderLayout.CENTER);

        // 하단 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        JButton confirmButton = new JButton("완료");
        confirmButton.setBackground(new Color(189, 204, 227));
        confirmButton.setPreferredSize(new Dimension(70, 30));

        buttonPanel.add(confirmButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManagerMain();
            }
        });
    }
}

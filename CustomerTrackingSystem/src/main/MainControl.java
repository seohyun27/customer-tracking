package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControl extends JFrame {
    private JPanel mainPanel; // 주 패널
    private CardLayout cardLayout; // 패널 전환을 위한 레이아웃
    private String savedID; // 저장된 아이디
    private int savedPassword;
    private Server server;

    // 패널 식별자 상수
    private static final String PASSWORD_PANEL = "패스워드패널";
    private static final String LOGIN_PANEL = "로그인패널";
    private static final String M_LOGIN_PANEL = "매니저로그인패널";
    private static final String O_LOGIN_PANEL = "점주로그인패널";

    private JPasswordField managerPasswordField; // 매니저 비밀번호 입력 필드

    public MainControl() { //생성자
        setTitle("비밀번호 초기화");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout 초기화
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // 비밀번호 패널 생성 및 추가
        JPanel passwordPanel = createPasswordPanel();
        mainPanel.add(passwordPanel, PASSWORD_PANEL);

        // 로그인 선택 패널 생성 및 추가
        JPanel loginChoosePanel = createChooseLogin();
        mainPanel.add(loginChoosePanel, LOGIN_PANEL);

        //매니저 로그인 패널 생성 및 추가
        JPanel ManagerloginPanel = createManagerLogin();
        mainPanel.add(ManagerloginPanel, M_LOGIN_PANEL);

        //점주 로그인 패널 생성 및 추가
        JPanel OwnerloginPanel = createOwnerLogin();
        mainPanel.add(OwnerloginPanel, O_LOGIN_PANEL);

        // 초기 화면은 비밀번호 패널로 설정
        cardLayout.show(mainPanel, PASSWORD_PANEL);

        // 메인 패널을 프레임에 추가
        add(mainPanel);

        // 창 설정
        setSize(850, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 비밀번호 초기화 화면 패널 생성 메소드
    public JPanel createPasswordPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 설명 라벨
        JLabel titleLabel = new JLabel("<html>매니저 로그인을 위해 사용할<br>비밀번호를 입력하세요</html>", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        // 중앙 입력창 패널
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel passwordLabel = new JLabel("비밀번호");
        passwordLabel.setOpaque(true);
        passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setPreferredSize(new Dimension(80, 30));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(250, 30));
        passwordField.setBackground(new Color(227, 232, 239));

        gbc.gridx = 0;
        gbc.gridy = 0;
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

        // 완료 버튼에 액션 리스너 추가
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwordText = new String(passwordField.getPassword());
                if (passwordText.length() >= 6) {
                    try {
                        // 비밀번호를 정수로 변환하여 저장
                        savedPassword = Integer.parseInt(passwordText);

                        // Manager 인스턴스 생성 및 비밀번호 저장
                        Manager manager = new Manager(savedPassword);
                        server = new Server(manager);

                        // 로그인 화면으로 전환
                        setTitle("로그인");
                        cardLayout.show(mainPanel, LOGIN_PANEL);
                    } catch (NumberFormatException ex) {
                        // 숫자로 변환 실패 시 처리 (예: 비밀번호에 숫자가 아닌 문자 포함)
                        JOptionPane.showMessageDialog(MainControl.this, "비밀번호는 숫자만 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // 6자리 미만일 때 메시지 출력
                    JOptionPane.showMessageDialog(MainControl.this, "비밀번호는 6자리 이상으로 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        buttonPanel.add(confirmButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    //매니저 or 점주 로그인을 선택하는 패널 생성 메소드
    public JPanel createChooseLogin() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 버튼을 담을 패널
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // 매니저 로그인 버튼
        JButton managerButton = new JButton("매니저 로그인");
        managerButton.setPreferredSize(new Dimension(150, 40));
        managerButton.setBackground(new Color(189, 204, 227));

        //매니저 로그인 버튼에 액션 리스너 추가
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // 매니저 로그인 패널로 전환
                setTitle("매니저 로그인");
                cardLayout.show(mainPanel, M_LOGIN_PANEL);
            }
        });

        // 점주 로그인 버튼
        JButton ownerButton = new JButton("점주 로그인");
        ownerButton.setPreferredSize(new Dimension(150, 40));
        ownerButton.setBackground(new Color(189, 204, 227));

        //점주 로그인 버튼에 액션 리스너 추가
        ownerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // 점주 로그인 패널로 전환
                setTitle("점주 로그인");
                cardLayout.show(mainPanel, O_LOGIN_PANEL);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(managerButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(ownerButton, gbc);

        panel.add(buttonPanel, BorderLayout.CENTER);

        // 제목 라벨
        JLabel titleLabel = new JLabel("로그인 유형을 선택하세요", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        return panel;
    }

    //매니저 로그인 패널을 만드는 메소드
    public JPanel createManagerLogin() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("매니저 로그인", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel passwordLabel = new JLabel("비밀번호");
        passwordLabel.setOpaque(true);
        passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setPreferredSize(new Dimension(80, 30));

        // 멤버 변수로 선언된 passwordField 할당
        managerPasswordField = new JPasswordField();
        managerPasswordField.setPreferredSize(new Dimension(250, 30));
        managerPasswordField.setBackground(new Color(227, 232, 239));

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(managerPasswordField, gbc);

        panel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        JButton confirmButton = new JButton("완료");
        confirmButton.setBackground(new Color(189, 204, 227));
        confirmButton.setPreferredSize(new Dimension(70, 30));

        // 버튼 액션
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputPasswordStr = new String(managerPasswordField.getPassword());
                try {
                    int inputPassword = Integer.parseInt(inputPasswordStr);
                    if (server != null && server.getManager() != null) {
                        int storedPassword = server.getManager().getPW();
                        if (inputPassword == storedPassword) {
                            SwingUtilities.invokeLater(() -> {
                                new ManagerMain(server);
                                // 기존 창 닫기
                                MainControl.this.dispose();
                            });
                        } else {
                            JOptionPane.showMessageDialog(MainControl.this, "잘못된 비밀번호를 입력하였습니다", "오류", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(MainControl.this, "서버 또는 매니저 정보가 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainControl.this, "비밀번호는 숫자만 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPanel.add(confirmButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    //오너 로그인 패널을 만드는 메소드
    public JPanel createOwnerLogin() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 설명 라벨
        JLabel titleLabel = new JLabel("점주 로그인", SwingConstants.CENTER);
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
                new MainControl();
            }
        });
    }
}


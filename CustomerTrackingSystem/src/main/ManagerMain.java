package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagerMain extends JFrame {
    private Server server;
    private JPanel mainPanel; // 주 패널
    private CardLayout cardLayout; // 패널 전환을 위한 레이아웃
    private Owner statsOwner; // 통계를 보기 위해 선택된 오너

    //패널 식별자 변수
    private static final String M_MAIN_PANEL = "매니저 메인 화면 패널"; //빈 화면
    private static final String ADD_OWNER_PANEL = "점주 추가 패널";
    private static final String DEL_OWNER_PANEL = "점주 삭제 패널";
    private static final String LIST_OWNER_PANEL = "점주 리스트 패널";
    private static final String CHOOSE_OWNER_PANEL = "통계 점주 선택 패널";
    private static final String M_STATS_PANEL = "통계 보기 패널";

    public ManagerMain(Server server) {//생성자
        this.server = server;

        setTitle("매니저");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CardLayout 초기화
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        //매니저 메인 패널 생성 및 추가
        JPanel ownerMainPanel = createMainPanel();
        mainPanel.add(ownerMainPanel, ADD_OWNER_PANEL);

        // 점주 추가 패널 생성 및 추가
        JPanel addOwnerPanel = createAddPanel();
        mainPanel.add(addOwnerPanel, ADD_OWNER_PANEL);

        //점주 삭제 패널 생성 및 추가
        JPanel delOwnerPanel = createDelPanel();
        mainPanel.add(delOwnerPanel, DEL_OWNER_PANEL);

        //점주 리스트 패널 생성 및 추가
        JPanel listOwnerPanel = createListPanel();
        mainPanel.add(listOwnerPanel, LIST_OWNER_PANEL);

        //통계 점주 선택 패널 생성 및 추가
        JPanel chooseOwnerPanel = chooseOwnerPanel();
        mainPanel.add(chooseOwnerPanel, CHOOSE_OWNER_PANEL);

        //통계 보기 패널 생성 및 추가
        JPanel statsPanel = createStatsPanel();
        mainPanel.add(statsPanel, M_STATS_PANEL);

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
        JMenu logout = new JMenu("로그아웃");

        // 메뉴 아이템 클릭 이벤트 추가
        ownerAdd.addActionListener(e -> cardLayout.show(mainPanel, ADD_OWNER_PANEL));
        ownerDel.addActionListener(e -> cardLayout.show(mainPanel, DEL_OWNER_PANEL));
        ownerList.addActionListener(e -> cardLayout.show(mainPanel, LIST_OWNER_PANEL));

        // 마우스 클릭 이벤트 추가
        // 통계보기
        stats.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(mainPanel, CHOOSE_OWNER_PANEL);
            }
        });

        // 로그아웃
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new MainControl(server); // 로그인 화면 열기
                ManagerMain.this.dispose(); // 기존 창 닫기
            }
        });


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

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().trim();
                String pwText = new String(passwordField.getPassword()).trim();

                //return 값이 false라면 해당 ID를 가진 점주가 이미 존재합니다
                //비밀번호가 6자리 이상의 숫자인지만 확인 -> 아니라면 비밀번호는 6자리 이상이어야 합니다 출력

                if (id.isEmpty() || pwText.isEmpty()) {
                    return;
                }

                if (!pwText.matches("\\d+")) { // PW가 숫자인지 체크
                    JOptionPane.showMessageDialog(ManagerMain.this, "비밀번호는 숫자만 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (pwText.length() < 6) { //PW가 6자리 이상인지 체크
                    JOptionPane.showMessageDialog(ManagerMain.this, "비밀번호는 6자리 이상이어야 합니다.", "경고", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int pw = Integer.parseInt(pwText);

                    // 서버에 추가
                    if (server != null) {
                        if (server.addOwner(id, pw)) {
                            JOptionPane.showMessageDialog(ManagerMain.this, "점주가 성공적으로 추가되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
                            idField.setText("");
                            passwordField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(ManagerMain.this, "해당 아이디를 가진 점주가 이미 존재합니다.", "오류", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ManagerMain.this, "오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPanel.add(confirmButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    //점주 삭제 패널을 생성하는 메소드
    public JPanel createDelPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 설명 라벨
        JLabel titleLabel = new JLabel("삭제할 점주의 아이디를 입력하세요", SwingConstants.CENTER);
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

        // 아이디 필드 추가
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        inputPanel.add(idField, gbc);

        panel.add(inputPanel, BorderLayout.CENTER);

        // 하단 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        JButton confirmButton = new JButton("완료");
        confirmButton.setBackground(new Color(189, 204, 227));
        confirmButton.setPreferredSize(new Dimension(70, 30));

        confirmButton.addActionListener(e -> { //삭제할 점주의 ID를 입력한 뒤 "완료"를 클릭
            String inputID = idField.getText().trim();

            if (inputID.isEmpty()) {
                return;
            }

            if (server.delOwner(inputID))
                JOptionPane.showMessageDialog(this, "해당 점주가 삭제되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "입력한 아이디를 가진 점주가 존재하지 않습니다", "오류", JOptionPane.WARNING_MESSAGE);

            idField.setText(""); // 입력창 초기화
        });

        buttonPanel.add(confirmButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    //점주 리스트 패널을 생성하는 메소드
    public JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 설명 라벨
        JLabel titleLabel = new JLabel("등록된 점주 리스트", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        // 중앙 패널에 스크롤이 가능한 리스트를 추가
        ArrayList<String> ownerNameList = server.getOwnerIDs(); // Server 클래스에서 받아온 arraylist
        String[] ownerNames = ownerNameList.toArray(new String[0]); // 배열 타입으로 변환
        JList<String> ownerIDList = new JList<>(ownerNames);
        ownerIDList.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        ownerIDList.setEnabled(false);  // 읽기 전용

        JScrollPane scrollPane = new JScrollPane(ownerIDList);
        scrollPane.setPreferredSize(new Dimension(250, 200));

        // FlowLayout을 사용하는 패널에 스크롤 페인지를 감싸서 중앙으로 배치
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(scrollPane);

        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }

    // 통계를 확인할 점주를 선택하는 패널을 생성하는 메소드
    public JPanel chooseOwnerPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 설명 라벨
        JLabel titleLabel = new JLabel("통계를 확인하고 싶은 점주의 아이디를 입력하세요", SwingConstants.CENTER);
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

        // 아이디 필드 추가
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        inputPanel.add(idField, gbc);

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
                String inputID = idField.getText().trim();
                statsOwner = server.getOwner(inputID);

                // 점주가 존재하지 않는 경우
                if (statsOwner == null) {
                    JOptionPane.showMessageDialog(ManagerMain.this,
                            "해당 아이디를 가진 점주가 존재하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                cardLayout.show(mainPanel, M_STATS_PANEL); // 점주가 존재하는 경우 통계 패널로 이동
                idField.setText(""); // 입력창 초기화
            }
        });

        buttonPanel.add(confirmButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }


    // 아직 구현되지 않은 기능
    // 점주별 통계 패널을 생성하는 메소드
    public JPanel createStatsPanel() {
        // 메인 패널: BorderLayout을 사용하여 상단과 중앙을 나눕니다.
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 패널 (JComboBox 하나만 왼쪽에 배치)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        topPanel.setBackground(Color.WHITE);

        // JComboBox
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"(기준 선택)", "성별", "나이", "입장 시간대"});
        topPanel.add(comboBox);
        panel.add(topPanel, BorderLayout.NORTH);

        // 중앙 그룹 패널 (3개의 컴포넌트가 화면을 가득 채우도록 설정)
        JPanel centerGroupPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        centerGroupPanel.setBackground(Color.WHITE);

        // 컴포넌트 1
        JPanel comp1 = new JPanel();
        comp1.setBackground(new Color(220, 240, 255));
        comp1.add(new JLabel("그래프 1"));

        // 컴포넌트 2
        JPanel comp2 = new JPanel();
        comp2.setBackground(new Color(220, 240, 255));
        comp2.add(new JLabel("그래프 2"));

        // 컴포넌트 3
        JPanel comp3 = new JPanel();
        comp3.setBackground(new Color(220, 240, 255));
        comp3.add(new JLabel("그래프 3"));

        // 그룹 패널에 컴포넌트 추가
        centerGroupPanel.add(comp1);
        centerGroupPanel.add(comp2);
        centerGroupPanel.add(comp3);

        // 화면을 채우기 위해 BorderLayout.CENTER에 추가
        panel.add(centerGroupPanel, BorderLayout.CENTER);

        return panel;
    }

    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManagerMain();
            }
        });
    }
    */
}
package br.com.villadev.rps.core.gamestate;

public class RPSStateMachine {

    private final GameContext context;

    private final WelcomeGameState welcomeState;
    private final HelpGameState helpState;
    private final ExitGameState exitGameState;
    private final MatchGameState matchState;
    private final ReplayGameState replayState;

    private GameState current;

    public RPSStateMachine(GameContext context) {
        this.context = context;
        this.welcomeState = new WelcomeGameState(this);
        this.helpState = new HelpGameState(this);
        this.exitGameState = new ExitGameState(this);
        this.matchState = new MatchGameState(this, context);
        this.replayState = new ReplayGameState(this);
        this.current = welcomeState;
    }

    public GameState getCurrent() {
        return current;
    }

    public void setCurrent(GameState next) {
        // Reset match rounds when entering match state from a different state
        if (next == matchState && current != matchState) {
            matchState.reset();
        }
        this.current = next;
    }

    public WelcomeGameState getWelcomeState() {
        return welcomeState;
    }

    public HelpGameState getHelpState() {
        return helpState;
    }

    public ExitGameState getExitGameState() {
        return exitGameState;
    }

    public MatchGameState getMatchState() {
        return matchState;
    }

    public ReplayGameState getReplayState() {
        return replayState;
    }

    public GameContext getContext() {
        return context;
    }
}

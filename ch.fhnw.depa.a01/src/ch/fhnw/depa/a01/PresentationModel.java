package ch.fhnw.depa.a01;

public final class PresentationModel {

	private final ObservableColor color;

	public PresentationModel(ObservableColor color) {
		this.color = color;
	}

	public ObservableColor getColor() {
		return color;
	}

}
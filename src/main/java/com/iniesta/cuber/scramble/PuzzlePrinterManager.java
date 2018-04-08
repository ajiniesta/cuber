package com.iniesta.cuber.scramble;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;

import com.iniesta.cuber.manager.CuberException;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import net.gnehzr.tnoodle.scrambles.InvalidScrambleException;
import net.gnehzr.tnoodle.scrambles.Puzzle;
import net.gnehzr.tnoodle.svglite.Color;

public class PuzzlePrinterManager {

	public PuzzlePrinterManager() {
	}

	public Image drawImage(Puzzle cp, String wcaScramble) throws CuberException {
		return drawImage(cp, wcaScramble, cp.getDefaultColorScheme());
	}

	public Image drawImage(Puzzle cp, String wcaScramble, HashMap<String, Color> colorScheme) throws CuberException {
		try {
			String inputSvg = cp.drawScramble(wcaScramble, cp.getDefaultColorScheme()).toString();

			BufferedImageTranscoder trans = new BufferedImageTranscoder();

			TranscoderInput transIn = new TranscoderInput(new ByteArrayInputStream(inputSvg.getBytes()));
			trans.transcode(transIn, null);
			Image img = SwingFXUtils.toFXImage(trans.getBufferedImage(), null);

			return img;
		} catch (InvalidScrambleException | TranscoderException e) {
			throw new CuberException("Error during the generation of the scramble image", e);
		}
	}

}

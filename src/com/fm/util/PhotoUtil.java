package com.fm.util;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class PhotoUtil {
	String fromFileStr;
	String saveToFileStr;
	String sysimgfile;
	int width;
	int height;
	String suffix;

	/**
	 * @param fromFileStr
	 *            原始图片完整路径
	 * @param saveToFileStr
	 *            缩略图片保存路径
	 * @param sysimgfilenNow
	 *            处理后的图片文件名前缀
	 * 
	 */
	private PhotoUtil(String fromFileStr, String saveToFileStr,
			String sysimgfile, String suffix, int width, int height) {
		this.fromFileStr = fromFileStr;
		this.saveToFileStr = saveToFileStr;
		this.sysimgfile = sysimgfile;
		this.width = width;
		this.height = height;
		this.suffix = suffix;
	}

	/**
	 * @param fromFileStr
	 *            原始图片完整路径
	 * @param saveToFileStr
	 *            缩略图片保存路径
	 * @param sysimgfilenNow
	 *            处理后的图片文件名前缀
	 * 
	 */
	private PhotoUtil() {

	}

	/**
	 * @param fromFileStr
	 *            原始图片完整路径
	 * @param saveToFileStr
	 *            缩略图片保存路径
	 * @param sysimgfilenNow
	 *            处理后的图片文件名前缀
	 * 
	 */
	public void setValue(String fromFileStr, String saveToFileStr,
			String sysimgfile, String suffix, int width, int height) {
		this.fromFileStr = fromFileStr;
		this.saveToFileStr = saveToFileStr;
		this.sysimgfile = sysimgfile;
		this.width = width;
		this.height = height;
		this.suffix = suffix;
	}

	public boolean createThumbnail() {
		// fileExtNmae是图片的格式 gif JPG 或png
		// String fileExtNmae="";
		double Ratio = 0.0;
		try {
			File F = new File(fromFileStr);
			// if (!F.isFile())
			// throw new Exception(F
			// + " is not image file error in CreateThumbnail!");
			File ThF = new File(saveToFileStr, sysimgfile + "." + suffix);
			BufferedImage Bi = ImageIO.read(F);
			Image Itemp = Bi.getScaledInstance(width, height,
					BufferedImage.SCALE_SMOOTH);
			if ((Bi.getHeight() >= width) || (Bi.getWidth() >= height)) {
				if (Bi.getHeight() > Bi.getWidth())
					Ratio = (double) width / Bi.getHeight();
				else
					Ratio = (double) height / Bi.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(
					AffineTransform.getScaleInstance(Ratio, Ratio), null);
			Itemp = op.filter(Bi, null);

			ImageIO.write((BufferedImage) Itemp, suffix, ThF);
		} catch (Exception ex) {
			// throw new Exception(" ImageIo.write error in CreatThum.: "
			// + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
		return (true);
	}

	private static PhotoUtil photoUtil = null;

	public static PhotoUtil getInstance() {
		if (photoUtil == null)
			photoUtil = new PhotoUtil();
		return photoUtil;
	}

	public static void main(String[] args) {
		PhotoUtil UI;
		boolean ss = false;
		try {
			UI = new PhotoUtil("E:/tmp/picture/5.jpg", "E:/tmp/picture/", "s5",
					"jpg", 150, 150);
			ss = UI.createThumbnail();
			if (ss) {
				System.out.println("Success");
			} else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}
}

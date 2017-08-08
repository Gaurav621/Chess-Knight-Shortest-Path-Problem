package collection;

import java.util.Scanner;

public class StepsByKnight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TCase = sc.nextInt();
		while (TCase > 0) {
			int size = sc.nextInt();
			int kx = sc.nextInt();
			int ky = sc.nextInt();
			int tx = sc.nextInt();
			int ty = sc.nextInt();
			
			if(kx<tx||ky<ty) {
				kx=kx+tx;
				tx=kx-tx;
				kx=kx-tx;
				ky=ky+ty;
				ty=ky-ty;
				ky=ky-ty;
			}

			int kxx = Math.abs(kx - tx);
			int kyy = Math.abs(ky - ty);
			int txx = 0, tyy = 0;
			double dis = Math.sqrt(Math.pow((kxx - txx), 2) + Math.pow((kyy - tyy), 2));
			int kx1 = 0;
			int count = 0;
			int maxVal = 0;
			if (kxx < kyy) {
				int kxCopy = kxx;
				kxx = kyy;
				kyy = kxCopy;
			}
			if (dis > Math.sqrt(8)) {
				if (kxx % 2 != 0) {
					kx1 = (kxx + 1) / 2;
					maxVal = kxx + 1;
				} else {
					kx1 = kxx / 2;
					maxVal = kxx;
				}
				while (dis > Math.sqrt(Math.pow(maxVal, 2) + Math.pow(maxVal - (kx1 - 1), 2))) {
					maxVal += 2;
					kx1 += 1;
				}
				if (((maxVal / 2) % 2) == 0) {
					if ((Math.pow(kxx, 2) + Math.pow(kyy, 2)) % 2 == 0) {
						count = kx1;
					} else {
						count = kx1 + 1;
					}
				} else {
					if ((Math.pow(kxx, 2) + Math.pow(kyy, 2)) % 2 == 0) {
						count = kx1+1;
					} else {
						count = kx1;
					}
				}
			} else {
				if ((Math.pow((kxx - txx), 2) + Math.pow((kyy - tyy), 2) == 5)) {
					count = 1;
				} else if ((Math.pow((kxx - txx), 2) + Math.pow((kyy - tyy), 2)) == 8) {
					count = 4;
				} else if ((Math.pow((kxx - txx), 2) + Math.pow((kyy - tyy), 2)) == 1) {
					if (size == 2) {
						count = 1;
					} else {
						count = 3;
					}
				} else if ((Math.pow((kxx - txx), 2) + Math.pow((kyy - tyy), 2)) == 0) {
					count = 0;
				} else {
					if ((kx <= 2) && (ky <= 2)) {
						if (size <= 3) {
							count = 1;
						} else {
							count = 4;
						}
					} else {
						count = 2;
					}
				}
			}
			System.out.println(count);

			TCase--;

		}
	}
}
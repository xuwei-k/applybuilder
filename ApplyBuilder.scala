
package scalaz

object ApplyBuilder {


  def %[F1, F2](f1: => F1, f2: => F2)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2]) =
    new Apply2[F1.M, F2.M, F1.A, F2.A](F1(f1), F2(f2), F1.TC)


  def %%[F1, F2, F3](f1: => F1, f2: => F2, f3: => F3)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3]) =
    new Apply3[F1.M, F2.M, F3.M, F1.A, F2.A, F3.A](F1(f1), F2(f2), F3(f3), F1.TC)


  def %%%[F1, F2, F3, F4](f1: => F1, f2: => F2, f3: => F3, f4: => F4)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4]) =
    new Apply4[F1.M, F2.M, F3.M, F4.M, F1.A, F2.A, F3.A, F4.A](F1(f1), F2(f2), F3(f3), F4(f4), F1.TC)


  def %%%%[F1, F2, F3, F4, F5](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5]) =
    new Apply5[F1.M, F2.M, F3.M, F4.M, F5.M, F1.A, F2.A, F3.A, F4.A, F5.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F1.TC)


  def %%%%%[F1, F2, F3, F4, F5, F6](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6]) =
    new Apply6[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F1.TC)


  def %%%%%%[F1, F2, F3, F4, F5, F6, F7](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7]) =
    new Apply7[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F1.TC)


  def %%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8]) =
    new Apply8[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F1.TC)


  def %%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9]) =
    new Apply9[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F1.TC)


  def %%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10]) =
    new Apply10[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F1.TC)


  def %%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11]) =
    new Apply11[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F1.TC)


  def %%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12]) =
    new Apply12[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F1.TC)


  def %%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13]) =
    new Apply13[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F1.TC)


  def %%%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13, f14: => F14)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13], F14: Unapply[Apply, F14]) =
    new Apply14[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F14.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A, F14.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F14(f14), F1.TC)


  def %%%%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13, f14: => F14, f15: => F15)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13], F14: Unapply[Apply, F14], F15: Unapply[Apply, F15]) =
    new Apply15[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F14.M, F15.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A, F14.A, F15.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F14(f14), F15(f15), F1.TC)


  def %%%%%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13, f14: => F14, f15: => F15, f16: => F16)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13], F14: Unapply[Apply, F14], F15: Unapply[Apply, F15], F16: Unapply[Apply, F16]) =
    new Apply16[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F14.M, F15.M, F16.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A, F14.A, F15.A, F16.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F14(f14), F15(f15), F16(f16), F1.TC)


  def %%%%%%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13, f14: => F14, f15: => F15, f16: => F16, f17: => F17)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13], F14: Unapply[Apply, F14], F15: Unapply[Apply, F15], F16: Unapply[Apply, F16], F17: Unapply[Apply, F17]) =
    new Apply17[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F14.M, F15.M, F16.M, F17.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A, F14.A, F15.A, F16.A, F17.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F14(f14), F15(f15), F16(f16), F17(f17), F1.TC)


  def %%%%%%%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13, f14: => F14, f15: => F15, f16: => F16, f17: => F17, f18: => F18)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13], F14: Unapply[Apply, F14], F15: Unapply[Apply, F15], F16: Unapply[Apply, F16], F17: Unapply[Apply, F17], F18: Unapply[Apply, F18]) =
    new Apply18[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F14.M, F15.M, F16.M, F17.M, F18.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A, F14.A, F15.A, F16.A, F17.A, F18.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F14(f14), F15(f15), F16(f16), F17(f17), F18(f18), F1.TC)


  def %%%%%%%%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18, F19](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13, f14: => F14, f15: => F15, f16: => F16, f17: => F17, f18: => F18, f19: => F19)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13], F14: Unapply[Apply, F14], F15: Unapply[Apply, F15], F16: Unapply[Apply, F16], F17: Unapply[Apply, F17], F18: Unapply[Apply, F18], F19: Unapply[Apply, F19]) =
    new Apply19[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F14.M, F15.M, F16.M, F17.M, F18.M, F19.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A, F14.A, F15.A, F16.A, F17.A, F18.A, F19.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F14(f14), F15(f15), F16(f16), F17(f17), F18(f18), F19(f19), F1.TC)


  def %%%%%%%%%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18, F19, F20](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13, f14: => F14, f15: => F15, f16: => F16, f17: => F17, f18: => F18, f19: => F19, f20: => F20)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13], F14: Unapply[Apply, F14], F15: Unapply[Apply, F15], F16: Unapply[Apply, F16], F17: Unapply[Apply, F17], F18: Unapply[Apply, F18], F19: Unapply[Apply, F19], F20: Unapply[Apply, F20]) =
    new Apply20[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F14.M, F15.M, F16.M, F17.M, F18.M, F19.M, F20.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A, F14.A, F15.A, F16.A, F17.A, F18.A, F19.A, F20.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F14(f14), F15(f15), F16(f16), F17(f17), F18(f18), F19(f19), F20(f20), F1.TC)


  def %%%%%%%%%%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18, F19, F20, F21](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13, f14: => F14, f15: => F15, f16: => F16, f17: => F17, f18: => F18, f19: => F19, f20: => F20, f21: => F21)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13], F14: Unapply[Apply, F14], F15: Unapply[Apply, F15], F16: Unapply[Apply, F16], F17: Unapply[Apply, F17], F18: Unapply[Apply, F18], F19: Unapply[Apply, F19], F20: Unapply[Apply, F20], F21: Unapply[Apply, F21]) =
    new Apply21[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F14.M, F15.M, F16.M, F17.M, F18.M, F19.M, F20.M, F21.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A, F14.A, F15.A, F16.A, F17.A, F18.A, F19.A, F20.A, F21.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F14(f14), F15(f15), F16(f16), F17(f17), F18(f18), F19(f19), F20(f20), F21(f21), F1.TC)


  def %%%%%%%%%%%%%%%%%%%%%[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18, F19, F20, F21, F22](f1: => F1, f2: => F2, f3: => F3, f4: => F4, f5: => F5, f6: => F6, f7: => F7, f8: => F8, f9: => F9, f10: => F10, f11: => F11, f12: => F12, f13: => F13, f14: => F14, f15: => F15, f16: => F16, f17: => F17, f18: => F18, f19: => F19, f20: => F20, f21: => F21, f22: => F22)(implicit F1: Unapply[Apply, F1], F2: Unapply[Apply, F2], F3: Unapply[Apply, F3], F4: Unapply[Apply, F4], F5: Unapply[Apply, F5], F6: Unapply[Apply, F6], F7: Unapply[Apply, F7], F8: Unapply[Apply, F8], F9: Unapply[Apply, F9], F10: Unapply[Apply, F10], F11: Unapply[Apply, F11], F12: Unapply[Apply, F12], F13: Unapply[Apply, F13], F14: Unapply[Apply, F14], F15: Unapply[Apply, F15], F16: Unapply[Apply, F16], F17: Unapply[Apply, F17], F18: Unapply[Apply, F18], F19: Unapply[Apply, F19], F20: Unapply[Apply, F20], F21: Unapply[Apply, F21], F22: Unapply[Apply, F22]) =
    new Apply22[F1.M, F2.M, F3.M, F4.M, F5.M, F6.M, F7.M, F8.M, F9.M, F10.M, F11.M, F12.M, F13.M, F14.M, F15.M, F16.M, F17.M, F18.M, F19.M, F20.M, F21.M, F22.M, F1.A, F2.A, F3.A, F4.A, F5.A, F6.A, F7.A, F8.A, F9.A, F10.A, F11.A, F12.A, F13.A, F14.A, F15.A, F16.A, F17.A, F18.A, F19.A, F20.A, F21.A, F22.A](F1(f1), F2(f2), F3(f3), F4(f4), F5(f5), F6(f6), F7(f7), F8(f8), F9(f9), F10(f10), F11(f11), F12(f12), F13(f13), F14(f14), F15(f15), F16(f16), F17(f17), F18(f18), F19(f19), F20(f20), F21(f21), F22(f22), F1.TC)


}


private[scalaz] final class Apply2[F1[_], F2[_], _1, _2](
  f1: => F1[_1], f2: => F2[_2], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2]
  ): F1[(_1, _2)] = run(Tuple2.apply)


  def run[Z](f: (_1, _2) => Z)(implicit
    _2: F2[_2] =:= F1[_2]
  ): F1[Z] = F.apply2(f1, _2(f2))(f)
}


private[scalaz] final class Apply3[F1[_], F2[_], F3[_], _1, _2, _3](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3]
  ): F1[(_1, _2, _3)] = run(Tuple3.apply)


  def run[Z](f: (_1, _2, _3) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3]
  ): F1[Z] = F.apply3(f1, _2(f2), _3(f3))(f)
}


private[scalaz] final class Apply4[F1[_], F2[_], F3[_], F4[_], _1, _2, _3, _4](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4]
  ): F1[(_1, _2, _3, _4)] = run(Tuple4.apply)


  def run[Z](f: (_1, _2, _3, _4) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4]
  ): F1[Z] = F.apply4(f1, _2(f2), _3(f3), _4(f4))(f)
}


private[scalaz] final class Apply5[F1[_], F2[_], F3[_], F4[_], F5[_], _1, _2, _3, _4, _5](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5]
  ): F1[(_1, _2, _3, _4, _5)] = run(Tuple5.apply)


  def run[Z](f: (_1, _2, _3, _4, _5) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5]
  ): F1[Z] = F.apply5(f1, _2(f2), _3(f3), _4(f4), _5(f5))(f)
}


private[scalaz] final class Apply6[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], _1, _2, _3, _4, _5, _6](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6]
  ): F1[(_1, _2, _3, _4, _5, _6)] = run(Tuple6.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6]
  ): F1[Z] = F.apply6(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6))(f)
}


private[scalaz] final class Apply7[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], _1, _2, _3, _4, _5, _6, _7](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7]
  ): F1[(_1, _2, _3, _4, _5, _6, _7)] = run(Tuple7.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7]
  ): F1[Z] = F.apply7(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7))(f)
}


private[scalaz] final class Apply8[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], _1, _2, _3, _4, _5, _6, _7, _8](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8)] = run(Tuple8.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8]
  ): F1[Z] = F.apply8(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8))(f)
}


private[scalaz] final class Apply9[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], _1, _2, _3, _4, _5, _6, _7, _8, _9](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9)] = run(Tuple9.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9]
  ): F1[Z] = F.apply9(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8), _9(f9))(f)
}


private[scalaz] final class Apply10[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10)] = run(Tuple10.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10]
  ): F1[Z] = F.apply10(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8), _9(f9), _10(f10))(f)
}


private[scalaz] final class Apply11[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)] = run(Tuple11.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11]
  ): F1[Z] = F.apply11(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8), _9(f9), _10(f10), _11(f11))(f)
}


private[scalaz] final class Apply12[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12)] = run(Tuple12.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12]
  ): F1[Z] = F.apply12(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8), _9(f9), _10(f10), _11(f11), _12(f12))(f)
}


private[scalaz] final class Apply13[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)] = run(Tuple13.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13]
  ): F1[Z] = F.apply2(
    F.apply6(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6))(Tuple6.apply),
    F.apply7(_7(f7), _8(f8), _9(f9), _10(f10), _11(f11), _12(f12), _13(f13))(Tuple7.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7)
  )
}


private[scalaz] final class Apply14[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], F14[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], f14: => F14[_14], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)] = run(Tuple14.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14]
  ): F1[Z] = F.apply2(
    F.apply7(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7))(Tuple7.apply),
    F.apply7(_8(f8), _9(f9), _10(f10), _11(f11), _12(f12), _13(f13), _14(f14))(Tuple7.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t1._7, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7)
  )
}


private[scalaz] final class Apply15[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], F14[_], F15[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], f14: => F14[_14], f15: => F15[_15], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)] = run(Tuple15.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15]
  ): F1[Z] = F.apply2(
    F.apply7(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7))(Tuple7.apply),
    F.apply8(_8(f8), _9(f9), _10(f10), _11(f11), _12(f12), _13(f13), _14(f14), _15(f15))(Tuple8.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t1._7, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7, t2._8)
  )
}


private[scalaz] final class Apply16[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], F14[_], F15[_], F16[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], f14: => F14[_14], f15: => F15[_15], f16: => F16[_16], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16)] = run(Tuple16.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16]
  ): F1[Z] = F.apply2(
    F.apply8(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8))(Tuple8.apply),
    F.apply8(_9(f9), _10(f10), _11(f11), _12(f12), _13(f13), _14(f14), _15(f15), _16(f16))(Tuple8.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t1._7, t1._8, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7, t2._8)
  )
}


private[scalaz] final class Apply17[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], F14[_], F15[_], F16[_], F17[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], f14: => F14[_14], f15: => F15[_15], f16: => F16[_16], f17: => F17[_17], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)] = run(Tuple17.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17]
  ): F1[Z] = F.apply2(
    F.apply8(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8))(Tuple8.apply),
    F.apply9(_9(f9), _10(f10), _11(f11), _12(f12), _13(f13), _14(f14), _15(f15), _16(f16), _17(f17))(Tuple9.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t1._7, t1._8, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7, t2._8, t2._9)
  )
}


private[scalaz] final class Apply18[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], F14[_], F15[_], F16[_], F17[_], F18[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], f14: => F14[_14], f15: => F15[_15], f16: => F16[_16], f17: => F17[_17], f18: => F18[_18], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18)] = run(Tuple18.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18]
  ): F1[Z] = F.apply2(
    F.apply9(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8), _9(f9))(Tuple9.apply),
    F.apply9(_10(f10), _11(f11), _12(f12), _13(f13), _14(f14), _15(f15), _16(f16), _17(f17), _18(f18))(Tuple9.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t1._7, t1._8, t1._9, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7, t2._8, t2._9)
  )
}


private[scalaz] final class Apply19[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], F14[_], F15[_], F16[_], F17[_], F18[_], F19[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], f14: => F14[_14], f15: => F15[_15], f16: => F16[_16], f17: => F17[_17], f18: => F18[_18], f19: => F19[_19], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18],
    _19: F19[_19] =:= F1[_19]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19)] = run(Tuple19.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18],
    _19: F19[_19] =:= F1[_19]
  ): F1[Z] = F.apply2(
    F.apply9(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8), _9(f9))(Tuple9.apply),
    F.apply10(_10(f10), _11(f11), _12(f12), _13(f13), _14(f14), _15(f15), _16(f16), _17(f17), _18(f18), _19(f19))(Tuple10.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t1._7, t1._8, t1._9, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7, t2._8, t2._9, t2._10)
  )
}


private[scalaz] final class Apply20[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], F14[_], F15[_], F16[_], F17[_], F18[_], F19[_], F20[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], f14: => F14[_14], f15: => F15[_15], f16: => F16[_16], f17: => F17[_17], f18: => F18[_18], f19: => F19[_19], f20: => F20[_20], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18],
    _19: F19[_19] =:= F1[_19],
    _20: F20[_20] =:= F1[_20]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20)] = run(Tuple20.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18],
    _19: F19[_19] =:= F1[_19],
    _20: F20[_20] =:= F1[_20]
  ): F1[Z] = F.apply2(
    F.apply10(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8), _9(f9), _10(f10))(Tuple10.apply),
    F.apply10(_11(f11), _12(f12), _13(f13), _14(f14), _15(f15), _16(f16), _17(f17), _18(f18), _19(f19), _20(f20))(Tuple10.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t1._7, t1._8, t1._9, t1._10, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7, t2._8, t2._9, t2._10)
  )
}


private[scalaz] final class Apply21[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], F14[_], F15[_], F16[_], F17[_], F18[_], F19[_], F20[_], F21[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], f14: => F14[_14], f15: => F15[_15], f16: => F16[_16], f17: => F17[_17], f18: => F18[_18], f19: => F19[_19], f20: => F20[_20], f21: => F21[_21], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18],
    _19: F19[_19] =:= F1[_19],
    _20: F20[_20] =:= F1[_20],
    _21: F21[_21] =:= F1[_21]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21)] = run(Tuple21.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18],
    _19: F19[_19] =:= F1[_19],
    _20: F20[_20] =:= F1[_20],
    _21: F21[_21] =:= F1[_21]
  ): F1[Z] = F.apply2(
    F.apply10(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8), _9(f9), _10(f10))(Tuple10.apply),
    F.apply11(_11(f11), _12(f12), _13(f13), _14(f14), _15(f15), _16(f16), _17(f17), _18(f18), _19(f19), _20(f20), _21(f21))(Tuple11.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t1._7, t1._8, t1._9, t1._10, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7, t2._8, t2._9, t2._10, t2._11)
  )
}


private[scalaz] final class Apply22[F1[_], F2[_], F3[_], F4[_], F5[_], F6[_], F7[_], F8[_], F9[_], F10[_], F11[_], F12[_], F13[_], F14[_], F15[_], F16[_], F17[_], F18[_], F19[_], F20[_], F21[_], F22[_], _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22](
  f1: => F1[_1], f2: => F2[_2], f3: => F3[_3], f4: => F4[_4], f5: => F5[_5], f6: => F6[_6], f7: => F7[_7], f8: => F8[_8], f9: => F9[_9], f10: => F10[_10], f11: => F11[_11], f12: => F12[_12], f13: => F13[_13], f14: => F14[_14], f15: => F15[_15], f16: => F16[_16], f17: => F17[_17], f18: => F18[_18], f19: => F19[_19], f20: => F20[_20], f21: => F21[_21], f22: => F22[_22], F: Apply[F1]
){


  def tupled(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18],
    _19: F19[_19] =:= F1[_19],
    _20: F20[_20] =:= F1[_20],
    _21: F21[_21] =:= F1[_21],
    _22: F22[_22] =:= F1[_22]
  ): F1[(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22)] = run(Tuple22.apply)


  def run[Z](f: (_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22) => Z)(implicit
    _2: F2[_2] =:= F1[_2],
    _3: F3[_3] =:= F1[_3],
    _4: F4[_4] =:= F1[_4],
    _5: F5[_5] =:= F1[_5],
    _6: F6[_6] =:= F1[_6],
    _7: F7[_7] =:= F1[_7],
    _8: F8[_8] =:= F1[_8],
    _9: F9[_9] =:= F1[_9],
    _10: F10[_10] =:= F1[_10],
    _11: F11[_11] =:= F1[_11],
    _12: F12[_12] =:= F1[_12],
    _13: F13[_13] =:= F1[_13],
    _14: F14[_14] =:= F1[_14],
    _15: F15[_15] =:= F1[_15],
    _16: F16[_16] =:= F1[_16],
    _17: F17[_17] =:= F1[_17],
    _18: F18[_18] =:= F1[_18],
    _19: F19[_19] =:= F1[_19],
    _20: F20[_20] =:= F1[_20],
    _21: F21[_21] =:= F1[_21],
    _22: F22[_22] =:= F1[_22]
  ): F1[Z] = F.apply2(
    F.apply11(f1, _2(f2), _3(f3), _4(f4), _5(f5), _6(f6), _7(f7), _8(f8), _9(f9), _10(f10), _11(f11))(Tuple11.apply),
    F.apply11(_12(f12), _13(f13), _14(f14), _15(f15), _16(f16), _17(f17), _18(f18), _19(f19), _20(f20), _21(f21), _22(f22))(Tuple11.apply)
  )((t1, t2) =>
    f(t1._1, t1._2, t1._3, t1._4, t1._5, t1._6, t1._7, t1._8, t1._9, t1._10, t1._11, t2._1, t2._2, t2._3, t2._4, t2._5, t2._6, t2._7, t2._8, t2._9, t2._10, t2._11)
  )
}



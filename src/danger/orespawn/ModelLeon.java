/*      */ package danger.orespawn;
/*      */ 
/*      */ import net.minecraft.client.model.ModelBase;
/*      */ import net.minecraft.client.model.ModelRenderer;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.util.MathHelper;
/*      */ 
/*      */ public class ModelLeon
/*      */   extends ModelBase
/*      */ {
/*   11 */   private float wingspeed = 1.0F;
/*      */   
/*      */   ModelRenderer chest;
/*      */   
/*      */   ModelRenderer neck_1;
/*      */   
/*      */   ModelRenderer neck_2;
/*      */   
/*      */   ModelRenderer neck_3;
/*      */   
/*      */   ModelRenderer abdomen;
/*      */   
/*      */   ModelRenderer head;
/*      */   
/*      */   ModelRenderer upper_jaw;
/*      */   
/*      */   ModelRenderer bottom_jaw;
/*      */   
/*      */   ModelRenderer chest_ridge;
/*      */   ModelRenderer upper_sail_1;
/*      */   ModelRenderer upper_sail2_;
/*      */   ModelRenderer upper_sail3;
/*      */   ModelRenderer lower_sail1;
/*      */   ModelRenderer lower_sail2;
/*      */   ModelRenderer lower_sail_3;
/*      */   ModelRenderer eye_ridge_L;
/*      */   ModelRenderer eye_ridge_R;
/*      */   ModelRenderer anntena_1_L;
/*      */   ModelRenderer anntena_1_R;
/*      */   ModelRenderer anntena_2_L;
/*      */   ModelRenderer anntena_2_R;
/*      */   ModelRenderer arm_1_L;
/*      */   ModelRenderer arm_2_L;
/*      */   ModelRenderer wing_1_L;
/*      */   ModelRenderer wing_2_L;
/*      */   ModelRenderer arm_1_R;
/*      */   ModelRenderer arm_2_R;
/*      */   ModelRenderer wing_1_R;
/*      */   ModelRenderer wing_2_R;
/*      */   ModelRenderer leg_1_L;
/*      */   ModelRenderer leg_1_R;
/*      */   ModelRenderer leg_2_L;
/*      */   ModelRenderer leg_2_R;
/*      */   ModelRenderer footL;
/*      */   ModelRenderer footR;
/*      */   ModelRenderer wing_3_L;
/*      */   ModelRenderer wing_3_R;
/*      */   ModelRenderer wing_4_L;
/*      */   ModelRenderer wing_4_R;
/*      */   ModelRenderer claw_L;
/*      */   ModelRenderer claw_R;
/*      */   ModelRenderer claw_L2;
/*      */   ModelRenderer claw_R_2;
/*      */   ModelRenderer wing_5_L;
/*      */   ModelRenderer wing_6_L;
/*      */   ModelRenderer wing_7_L;
/*      */   ModelRenderer wing_5_R;
/*      */   ModelRenderer wing_6_R;
/*      */   ModelRenderer wing_7_R;
/*      */   ModelRenderer fchest;
/*      */   ModelRenderer fneck_1;
/*      */   ModelRenderer fneck_2;
/*      */   ModelRenderer fneck_3;
/*      */   ModelRenderer fabdomen;
/*      */   ModelRenderer fhead;
/*      */   ModelRenderer fupper_jaw;
/*      */   ModelRenderer fbottom_jaw;
/*      */   ModelRenderer fchest_ridge;
/*      */   ModelRenderer fupper_sail_1;
/*      */   ModelRenderer fupper_sail2_;
/*      */   ModelRenderer fupper_sail3;
/*      */   ModelRenderer flower_sail1;
/*      */   ModelRenderer flower_sail2;
/*      */   ModelRenderer flower_sail_3;
/*      */   ModelRenderer feye_ridge_L;
/*      */   ModelRenderer feye_ridge_R;
/*      */   ModelRenderer fanntena_1_L;
/*      */   ModelRenderer fanntena_1_R;
/*      */   ModelRenderer fanntena_2_L;
/*      */   ModelRenderer fanntena_2_R;
/*      */   ModelRenderer farm_1_L;
/*      */   ModelRenderer farm_2_L;
/*      */   ModelRenderer fwing_1_L;
/*      */   ModelRenderer fwing_2_L;
/*      */   ModelRenderer farm_1_R;
/*      */   ModelRenderer farm_2_R;
/*      */   ModelRenderer fwing_1_R;
/*      */   ModelRenderer fwing_2_R;
/*      */   ModelRenderer fleg_1_L;
/*      */   ModelRenderer fleg_1_R;
/*      */   ModelRenderer fleg_2_L;
/*      */   ModelRenderer fleg_2_R;
/*      */   ModelRenderer ffootL;
/*      */   ModelRenderer ffootR;
/*      */   ModelRenderer fwing_3_L;
/*      */   ModelRenderer fwing_3_R;
/*      */   ModelRenderer fwing_4_L;
/*      */   ModelRenderer fwing_4_R;
/*      */   ModelRenderer fclaw_L;
/*      */   ModelRenderer fclaw_R;
/*      */   ModelRenderer fclaw_L2;
/*      */   ModelRenderer fclaw_R_2;
/*      */   ModelRenderer fwing_5_L;
/*      */   ModelRenderer fwing_6_L;
/*      */   ModelRenderer fwing_7_L;
/*      */   ModelRenderer fwing_5_R;
/*      */   ModelRenderer fwing_6_R;
/*      */   ModelRenderer fwing_7_R;
/*      */   
/*      */   public ModelLeon(float f1) {
/*  121 */     this.wingspeed = f1;
/*      */     
/*  123 */     this.textureWidth = 256;
/*  124 */     this.textureHeight = 256;
/*      */     
/*  126 */     this.chest = new ModelRenderer(this, 80, 0);
/*  127 */     this.chest.addBox(-8.0F, -9.5F, -9.5F, 16, 19, 19);
/*  128 */     this.chest.setRotationPoint(0.0F, -2.0F, -7.0F);
/*  129 */     this.chest.setTextureSize(256, 256);
/*  130 */     this.chest.mirror = true;
/*  131 */     setRotation(this.chest, -0.4363323F, 0.0F, 0.0F);
/*  132 */     this.neck_1 = new ModelRenderer(this, 106, 68);
/*  133 */     this.neck_1.addBox(-5.5F, -7.0F, -9.0F, 11, 14, 11);
/*  134 */     this.neck_1.setRotationPoint(0.0F, -6.0F, -13.0F);
/*  135 */     this.neck_1.setTextureSize(256, 256);
/*  136 */     this.neck_1.mirror = true;
/*  137 */     setRotation(this.neck_1, -0.8726646F, 0.0F, 0.0F);
/*  138 */     this.neck_2 = new ModelRenderer(this, 71, 69);
/*  139 */     this.neck_2.addBox(-4.0F, -5.0F, -8.0F, 8, 10, 9);
/*  140 */     this.neck_2.setRotationPoint(0.0F, -12.0F, -17.0F);
/*  141 */     this.neck_2.setTextureSize(256, 256);
/*  142 */     this.neck_2.mirror = true;
/*  143 */     setRotation(this.neck_2, -1.064651F, 0.0F, 0.0F);
/*  144 */     this.neck_3 = new ModelRenderer(this, 102, 94);
/*  145 */     this.neck_3.addBox(-3.0F, -4.0F, -17.0F, 6, 8, 18);
/*  146 */     this.neck_3.setRotationPoint(0.0F, -19.0F, -21.0F);
/*  147 */     this.neck_3.setTextureSize(256, 256);
/*  148 */     this.neck_3.mirror = true;
/*  149 */     setRotation(this.neck_3, -1.029744F, 0.0F, 0.0F);
/*  150 */     this.abdomen = new ModelRenderer(this, 96, 39);
/*  151 */     this.abdomen.addBox(-5.0F, -2.0F, 1.0F, 10, 11, 17);
/*  152 */     this.abdomen.setRotationPoint(0.0F, -5.0F, 4.0F);
/*  153 */     this.abdomen.setTextureSize(256, 256);
/*  154 */     this.abdomen.mirror = true;
/*  155 */     setRotation(this.abdomen, -0.6457718F, 0.0F, 0.0F);
/*  156 */     this.head = new ModelRenderer(this, 61, 49);
/*  157 */     this.head.addBox(-4.0F, -2.0F, -4.0F, 8, 8, 9);
/*  158 */     this.head.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  159 */     this.head.setTextureSize(256, 256);
/*  160 */     this.head.mirror = true;
/*  161 */     setRotation(this.head, -1.413717F, 0.0F, 0.0F);
/*  162 */     this.upper_jaw = new ModelRenderer(this, 83, 89);
/*  163 */     this.upper_jaw.addBox(-3.0F, 4.0F, -4.0F, 6, 13, 5);
/*  164 */     this.upper_jaw.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  165 */     this.upper_jaw.setTextureSize(256, 256);
/*  166 */     this.upper_jaw.mirror = true;
/*  167 */     setRotation(this.upper_jaw, -1.37881F, 0.0F, 0.0F);
/*  168 */     this.bottom_jaw = new ModelRenderer(this, 85, 108);
/*  169 */     this.bottom_jaw.addBox(-2.5F, -1.0F, -1.5F, 5, 12, 3);
/*  170 */     this.bottom_jaw.setRotationPoint(0.0F, -28.0F, -34.0F);
/*  171 */     this.bottom_jaw.setTextureSize(256, 256);
/*  172 */     this.bottom_jaw.mirror = true;
/*  173 */     setRotation(this.bottom_jaw, -1.413717F, 0.0F, 0.0F);
/*  174 */     this.chest_ridge = new ModelRenderer(this, 113, 129);
/*  175 */     this.chest_ridge.addBox(-2.0F, 7.0F, -3.0F, 4, 3, 17);
/*  176 */     this.chest_ridge.setRotationPoint(0.0F, -2.0F, -7.0F);
/*  177 */     this.chest_ridge.setTextureSize(256, 256);
/*  178 */     this.chest_ridge.mirror = true;
/*  179 */     setRotation(this.chest_ridge, -0.6283185F, 0.0F, 0.0F);
/*  180 */     this.upper_sail_1 = new ModelRenderer(this, 76, 110);
/*  181 */     this.upper_sail_1.addBox(-1.0F, -17.0F, -16.0F, 2, 14, 2);
/*  182 */     this.upper_sail_1.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  183 */     this.upper_sail_1.setTextureSize(256, 256);
/*  184 */     this.upper_sail_1.mirror = true;
/*  185 */     setRotation(this.upper_sail_1, 0.2443461F, 0.0F, 0.0F);
/*  186 */     this.upper_sail2_ = new ModelRenderer(this, 63, 110);
/*  187 */     this.upper_sail2_.addBox(-0.5F, -15.0F, -16.0F, 1, 12, 5);
/*  188 */     this.upper_sail2_.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  189 */     this.upper_sail2_.setTextureSize(256, 256);
/*  190 */     this.upper_sail2_.mirror = true;
/*  191 */     setRotation(this.upper_sail2_, 0.1396263F, 0.0F, 0.0F);
/*  192 */     this.upper_sail3 = new ModelRenderer(this, 0, 82);
/*  193 */     this.upper_sail3.addBox(0.0F, -1.5F, -18.0F, 0, 9, 13);
/*  194 */     this.upper_sail3.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  195 */     this.upper_sail3.setTextureSize(256, 256);
/*  196 */     this.upper_sail3.mirror = true;
/*  197 */     setRotation(this.upper_sail3, -0.7504916F, 0.0F, 0.0F);
/*  198 */     this.lower_sail1 = new ModelRenderer(this, 0, 2);
/*  199 */     this.lower_sail1.addBox(-1.0F, 0.0F, -10.0F, 2, 11, 2);
/*  200 */     this.lower_sail1.setRotationPoint(0.0F, -28.0F, -34.0F);
/*  201 */     this.lower_sail1.setTextureSize(256, 256);
/*  202 */     this.lower_sail1.mirror = true;
/*  203 */     setRotation(this.lower_sail1, 0.1919862F, 0.0F, 0.0F);
/*  204 */     this.lower_sail2 = new ModelRenderer(this, 52, 94);
/*  205 */     this.lower_sail2.addBox(-0.5F, 0.5F, -9.0F, 1, 9, 4);
/*  206 */     this.lower_sail2.setRotationPoint(0.0F, -28.0F, -34.0F);
/*  207 */     this.lower_sail2.setTextureSize(256, 256);
/*  208 */     this.lower_sail2.mirror = true;
/*  209 */     setRotation(this.lower_sail2, 0.296706F, 0.0F, 0.0F);
/*  210 */     this.lower_sail_3 = new ModelRenderer(this, 66, 90);
/*  211 */     this.lower_sail_3.addBox(0.0F, 1.5F, -4.0F, 0, 9, 7);
/*  212 */     this.lower_sail_3.setRotationPoint(0.0F, -28.0F, -34.0F);
/*  213 */     this.lower_sail_3.setTextureSize(256, 256);
/*  214 */     this.lower_sail_3.mirror = true;
/*  215 */     setRotation(this.lower_sail_3, -0.4886922F, 0.0F, 0.0F);
/*  216 */     this.eye_ridge_L = new ModelRenderer(this, 0, 68);
/*  217 */     this.eye_ridge_L.addBox(0.0F, -4.0F, -5.0F, 5, 2, 11);
/*  218 */     this.eye_ridge_L.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  219 */     this.eye_ridge_L.setTextureSize(256, 256);
/*  220 */     this.eye_ridge_L.mirror = true;
/*  221 */     setRotation(this.eye_ridge_L, 0.2094395F, 0.5585054F, 0.2268928F);
/*  222 */     this.eye_ridge_R = new ModelRenderer(this, 0, 68);
/*  223 */     this.eye_ridge_R.addBox(-5.0F, -4.0F, -5.0F, 5, 2, 11);
/*  224 */     this.eye_ridge_R.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  225 */     this.eye_ridge_R.setTextureSize(256, 256);
/*  226 */     this.eye_ridge_R.mirror = true;
/*  227 */     setRotation(this.eye_ridge_R, 0.2094395F, -0.5585054F, -0.2268928F);
/*  228 */     this.anntena_1_L = new ModelRenderer(this, 0, 40);
/*  229 */     this.anntena_1_L.addBox(3.0F, -4.2F, 5.0F, 2, 2, 5);
/*  230 */     this.anntena_1_L.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  231 */     this.anntena_1_L.setTextureSize(256, 256);
/*  232 */     this.anntena_1_L.mirror = true;
/*  233 */     setRotation(this.anntena_1_L, 0.2443461F, 0.3665191F, 0.2268928F);
/*  234 */     this.anntena_1_R = new ModelRenderer(this, 0, 40);
/*  235 */     this.anntena_1_R.addBox(-5.0F, -4.2F, 5.0F, 2, 2, 5);
/*  236 */     this.anntena_1_R.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  237 */     this.anntena_1_R.setTextureSize(256, 256);
/*  238 */     this.anntena_1_R.mirror = true;
/*  239 */     setRotation(this.anntena_1_R, 0.2443461F, -0.3665191F, -0.2268928F);
/*  240 */     this.anntena_2_L = new ModelRenderer(this, 46, 91);
/*  241 */     this.anntena_2_L.addBox(5.0F, -6.0F, 7.0F, 1, 1, 17);
/*  242 */     this.anntena_2_L.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  243 */     this.anntena_2_L.setTextureSize(256, 256);
/*  244 */     this.anntena_2_L.mirror = true;
/*  245 */     setRotation(this.anntena_2_L, 0.0698132F, 0.1396263F, 0.2268928F);
/*  246 */     this.anntena_2_R = new ModelRenderer(this, 46, 91);
/*  247 */     this.anntena_2_R.addBox(-6.0F, -6.0F, 7.0F, 1, 1, 17);
/*  248 */     this.anntena_2_R.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  249 */     this.anntena_2_R.setTextureSize(256, 256);
/*  250 */     this.anntena_2_R.mirror = true;
/*  251 */     setRotation(this.anntena_2_R, 0.0698132F, -0.1396263F, -0.2268928F);
/*  252 */     this.arm_1_L = new ModelRenderer(this, 77, 150);
/*  253 */     this.arm_1_L.addBox(0.0F, -1.0F, -1.0F, 3, 18, 5);
/*  254 */     this.arm_1_L.setRotationPoint(8.0F, -8.0F, -10.0F);
/*  255 */     this.arm_1_L.setTextureSize(256, 256);
/*  256 */     this.arm_1_L.mirror = true;
/*  257 */     setRotation(this.arm_1_L, -0.0698132F, 0.0F, -0.7679449F);
/*  258 */     this.arm_2_L = new ModelRenderer(this, 102, 150);
/*  259 */     this.arm_2_L.addBox(-0.5F, 0.0F, -1.0F, 2, 24, 3);
/*  260 */     this.arm_2_L.setRotationPoint(20.0F, 3.0F, -10.0F);
/*  261 */     this.arm_2_L.setTextureSize(256, 256);
/*  262 */     this.arm_2_L.mirror = true;
/*  263 */     setRotation(this.arm_2_L, -0.4712389F, 0.0F, -0.4886922F);
/*  264 */     this.wing_1_L = new ModelRenderer(this, 0, 33);
/*  265 */     this.wing_1_L.addBox(1.5F, -1.0F, 3.0F, 1, 19, 15);
/*  266 */     this.wing_1_L.setRotationPoint(8.0F, -8.0F, -10.0F);
/*  267 */     this.wing_1_L.setTextureSize(256, 256);
/*  268 */     this.wing_1_L.mirror = true;
/*  269 */     setRotation(this.wing_1_L, -0.1745329F, -0.1919862F, -0.7504916F);
/*  270 */     this.wing_2_L = new ModelRenderer(this, 33, 50);
/*  271 */     this.wing_2_L.addBox(0.0F, -1.0F, 1.0F, 1, 23, 17);
/*  272 */     this.wing_2_L.setRotationPoint(20.0F, 3.0F, -10.0F);
/*  273 */     this.wing_2_L.setTextureSize(256, 256);
/*  274 */     this.wing_2_L.mirror = true;
/*  275 */     setRotation(this.wing_2_L, -0.5235988F, -0.0349066F, -0.4712389F);
/*  276 */     this.arm_1_R = new ModelRenderer(this, 77, 127);
/*  277 */     this.arm_1_R.addBox(-3.0F, -1.0F, -1.0F, 3, 18, 5);
/*  278 */     this.arm_1_R.setRotationPoint(-8.0F, -8.0F, -10.0F);
/*  279 */     this.arm_1_R.setTextureSize(256, 256);
/*  280 */     this.arm_1_R.mirror = true;
/*  281 */     setRotation(this.arm_1_R, -0.0698132F, 0.0F, 0.7679449F);
/*  282 */     this.arm_2_R = new ModelRenderer(this, 102, 123);
/*  283 */     this.arm_2_R.addBox(-1.5F, 0.0F, -1.0F, 2, 24, 3);
/*  284 */     this.arm_2_R.setRotationPoint(-20.0F, 3.0F, -10.0F);
/*  285 */     this.arm_2_R.setTextureSize(256, 256);
/*  286 */     this.arm_2_R.mirror = true;
/*  287 */     setRotation(this.arm_2_R, -0.4712389F, 0.0F, 0.4886922F);
/*  288 */     this.wing_1_R = new ModelRenderer(this, 24, 150);
/*  289 */     this.wing_1_R.addBox(-2.5F, -1.0F, 3.0F, 1, 19, 15);
/*  290 */     this.wing_1_R.setRotationPoint(-8.0F, -8.0F, -10.0F);
/*  291 */     this.wing_1_R.setTextureSize(256, 256);
/*  292 */     this.wing_1_R.mirror = true;
/*  293 */     setRotation(this.wing_1_R, -0.1745329F, 0.1919862F, 0.7504916F);
/*  294 */     this.wing_2_R = new ModelRenderer(this, 150, 50);
/*  295 */     this.wing_2_R.addBox(-1.0F, -1.0F, 0.0F, 1, 23, 17);
/*  296 */     this.wing_2_R.setRotationPoint(-20.0F, 3.0F, -10.0F);
/*  297 */     this.wing_2_R.setTextureSize(256, 256);
/*  298 */     this.wing_2_R.mirror = true;
/*  299 */     setRotation(this.wing_2_R, -0.5235988F, 0.0349066F, 0.4712389F);
/*  300 */     this.leg_1_L = new ModelRenderer(this, 0, 104);
/*  301 */     this.leg_1_L.addBox(0.0F, -3.0F, -4.0F, 3, 15, 7);
/*  302 */     this.leg_1_L.setRotationPoint(5.0F, 5.0F, 10.0F);
/*  303 */     this.leg_1_L.setTextureSize(256, 256);
/*  304 */     this.leg_1_L.mirror = true;
/*  305 */     setRotation(this.leg_1_L, -0.6108652F, 0.0F, -0.3316126F);
/*  306 */     this.leg_1_R = new ModelRenderer(this, 0, 149);
/*  307 */     this.leg_1_R.addBox(-3.0F, -3.0F, -4.0F, 3, 15, 7);
/*  308 */     this.leg_1_R.setRotationPoint(-6.0F, 5.0F, 10.0F);
/*  309 */     this.leg_1_R.setTextureSize(256, 256);
/*  310 */     this.leg_1_R.mirror = true;
/*  311 */     setRotation(this.leg_1_R, -0.6108652F, 0.0F, 0.3316126F);
/*  312 */     this.leg_2_L = new ModelRenderer(this, 21, 108);
/*  313 */     this.leg_2_L.addBox(1.0F, 0.0F, -3.0F, 2, 14, 4);
/*  314 */     this.leg_2_L.setRotationPoint(8.0F, 13.0F, 6.0F);
/*  315 */     this.leg_2_L.setTextureSize(256, 256);
/*  316 */     this.leg_2_L.mirror = true;
/*  317 */     setRotation(this.leg_2_L, 0.6108652F, 0.0F, -0.1745329F);
/*      */     
/*  319 */     this.leg_2_R = new ModelRenderer(this, 21, 108);
/*  320 */     this.leg_2_R.addBox(-2.0F, 0.0F, -3.0F, 2, 14, 4);
/*  321 */     this.leg_2_R.setRotationPoint(-10.0F, 13.0F, 6.0F);
/*  322 */     this.leg_2_R.setTextureSize(256, 256);
/*  323 */     this.leg_2_R.mirror = true;
/*  324 */     setRotation(this.leg_2_R, 0.6108652F, 0.0F, 0.1745329F);
/*      */     
/*  326 */     this.footL = new ModelRenderer(this, 50, 29);
/*  327 */     this.footL.addBox(-2.0F, -1.0F, -8.0F, 4, 2, 9);
/*  328 */     this.footL.setRotationPoint(12.0F, 24.0F, 11.0F);
/*  329 */     this.footL.setTextureSize(256, 256);
/*  330 */     this.footL.mirror = true;
/*  331 */     setRotation(this.footL, 0.0F, 0.0F, 0.0F);
/*      */     
/*  333 */     this.footR = new ModelRenderer(this, 50, 29);
/*  334 */     this.footR.addBox(-1.0F, 1.0F, -8.0F, 4, 2, 9);
/*  335 */     this.footR.setRotationPoint(-14.0F, 22.0F, 11.0F);
/*  336 */     this.footR.setTextureSize(256, 256);
/*  337 */     this.footR.mirror = true;
/*  338 */     setRotation(this.footR, 0.0F, 0.0F, 0.0F);
/*      */     
/*  340 */     this.wing_3_L = new ModelRenderer(this, 0, 0);
/*  341 */     this.wing_3_L.addBox(-7.5F, 0.0F, -5.0F, 16, 1, 26);
/*  342 */     this.wing_3_L.setRotationPoint(-5.0F, 0.0F, 12.0F);
/*  343 */     this.wing_3_L.setTextureSize(256, 256);
/*  344 */     this.wing_3_L.mirror = true;
/*  345 */     setRotation(this.wing_3_L, -0.4886922F, -0.5235988F, 0.4014257F);
/*  346 */     this.wing_3_R = new ModelRenderer(this, 150, 0);
/*  347 */     this.wing_3_R.addBox(-8.5F, 0.0F, -5.0F, 16, 1, 26);
/*  348 */     this.wing_3_R.setRotationPoint(4.0F, 0.0F, 12.0F);
/*  349 */     this.wing_3_R.setTextureSize(256, 256);
/*  350 */     this.wing_3_R.mirror = true;
/*  351 */     setRotation(this.wing_3_R, -0.4886922F, 0.5235988F, -0.4014257F);
/*  352 */     this.wing_4_L = new ModelRenderer(this, 8, 117);
/*  353 */     this.wing_4_L.addBox(-1.5F, -0.5F, -2.0F, 3, 1, 31);
/*  354 */     this.wing_4_L.setRotationPoint(6.0F, 6.0F, 24.0F);
/*  355 */     this.wing_4_L.setTextureSize(256, 256);
/*  356 */     this.wing_4_L.mirror = true;
/*  357 */     setRotation(this.wing_4_L, -0.6283185F, -0.0174533F, 0.0F);
/*  358 */     this.wing_4_R = new ModelRenderer(this, 8, 117);
/*  359 */     this.wing_4_R.addBox(-1.5F, -0.5F, -2.0F, 3, 1, 31);
/*  360 */     this.wing_4_R.setRotationPoint(-7.0F, 6.0F, 24.0F);
/*  361 */     this.wing_4_R.setTextureSize(256, 256);
/*  362 */     this.wing_4_R.mirror = true;
/*  363 */     setRotation(this.wing_4_R, -0.6283185F, 0.0174533F, 0.0F);
/*  364 */     this.claw_L = new ModelRenderer(this, 0, 129);
/*  365 */     this.claw_L.addBox(0.0F, -1.0F, -9.0F, 1, 2, 10);
/*  366 */     this.claw_L.setRotationPoint(30.0F, 23.0F, -20.0F);
/*  367 */     this.claw_L.setTextureSize(256, 256);
/*  368 */     this.claw_L.mirror = true;
/*  369 */     setRotation(this.claw_L, 0.0F, 0.1570796F, 0.0F);
/*  370 */     this.claw_R = new ModelRenderer(this, 0, 129);
/*  371 */     this.claw_R.addBox(0.0F, -1.0F, -9.0F, 1, 2, 10);
/*  372 */     this.claw_R.setRotationPoint(-31.0F, 23.0F, -20.0F);
/*  373 */     this.claw_R.setTextureSize(256, 256);
/*  374 */     this.claw_R.mirror = true;
/*  375 */     setRotation(this.claw_R, 0.0F, -0.1570796F, 0.0F);
/*  376 */     this.claw_L2 = new ModelRenderer(this, 18, 38);
/*  377 */     this.claw_L2.addBox(0.0F, -2.5F, -6.0F, 1, 2, 7);
/*  378 */     this.claw_L2.setRotationPoint(-30.0F, 23.0F, -28.0F);
/*  379 */     this.claw_L2.setTextureSize(256, 256);
/*  380 */     this.claw_L2.mirror = true;
/*  381 */     setRotation(this.claw_L2, 0.5061455F, -0.2792527F, 0.0F);
/*  382 */     this.claw_R_2 = new ModelRenderer(this, 18, 38);
/*  383 */     this.claw_R_2.addBox(-1.0F, -2.5F, -6.0F, 1, 2, 7);
/*  384 */     this.claw_R_2.setRotationPoint(30.0F, 23.0F, -28.0F);
/*  385 */     this.claw_R_2.setTextureSize(256, 256);
/*  386 */     this.claw_R_2.mirror = true;
/*  387 */     setRotation(this.claw_R_2, 0.5061455F, 0.2792527F, 0.0F);
/*  388 */     this.wing_5_L = new ModelRenderer(this, 46, 10);
/*  389 */     this.wing_5_L.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  390 */     this.wing_5_L.setRotationPoint(31.0F, 21.0F, -19.0F);
/*  391 */     this.wing_5_L.setTextureSize(256, 256);
/*  392 */     this.wing_5_L.mirror = true;
/*  393 */     setRotation(this.wing_5_L, 0.6806784F, 0.0523599F, -0.2792527F);
/*  394 */     this.wing_6_L = new ModelRenderer(this, 46, 10);
/*  395 */     this.wing_6_L.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  396 */     this.wing_6_L.setRotationPoint(31.0F, 21.0F, -19.0F);
/*  397 */     this.wing_6_L.setTextureSize(256, 256);
/*  398 */     this.wing_6_L.mirror = true;
/*  399 */     setRotation(this.wing_6_L, 0.4537856F, 0.2443461F, -0.3665191F);
/*  400 */     this.wing_7_L = new ModelRenderer(this, 46, 10);
/*  401 */     this.wing_7_L.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  402 */     this.wing_7_L.setRotationPoint(-30.0F, 21.0F, -19.0F);
/*  403 */     this.wing_7_L.setTextureSize(256, 256);
/*  404 */     this.wing_7_L.mirror = true;
/*  405 */     setRotation(this.wing_7_L, 0.1396263F, -0.3316126F, 0.4014257F);
/*  406 */     this.wing_5_R = new ModelRenderer(this, 46, 10);
/*  407 */     this.wing_5_R.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  408 */     this.wing_5_R.setRotationPoint(-30.0F, 21.0F, -19.0F);
/*  409 */     this.wing_5_R.setTextureSize(256, 256);
/*  410 */     this.wing_5_R.mirror = true;
/*  411 */     setRotation(this.wing_5_R, 0.6806784F, -0.0523599F, 0.2792527F);
/*  412 */     this.wing_6_R = new ModelRenderer(this, 46, 10);
/*  413 */     this.wing_6_R.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  414 */     this.wing_6_R.setRotationPoint(-30.0F, 21.0F, -19.0F);
/*  415 */     this.wing_6_R.setTextureSize(256, 256);
/*  416 */     this.wing_6_R.mirror = true;
/*  417 */     setRotation(this.wing_6_R, 0.4537856F, -0.2443461F, 0.3665191F);
/*  418 */     this.wing_7_R = new ModelRenderer(this, 46, 10);
/*  419 */     this.wing_7_R.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  420 */     this.wing_7_R.setRotationPoint(31.0F, 21.0F, -19.0F);
/*  421 */     this.wing_7_R.setTextureSize(256, 256);
/*  422 */     this.wing_7_R.mirror = true;
/*  423 */     setRotation(this.wing_7_R, 0.1396263F, 0.3316126F, -0.4014257F);
/*      */ 
/*      */     
/*  426 */     this.fchest = new ModelRenderer(this, 80, 0);
/*  427 */     this.fchest.addBox(-8.0F, -9.5F, -9.5F, 16, 19, 19);
/*  428 */     this.fchest.setRotationPoint(0.0F, -2.0F, -7.0F);
/*  429 */     this.fchest.setTextureSize(256, 256);
/*  430 */     this.fchest.mirror = true;
/*  431 */     setRotation(this.fchest, -0.4363323F, 0.0F, 0.0F);
/*  432 */     this.fneck_1 = new ModelRenderer(this, 106, 68);
/*  433 */     this.fneck_1.addBox(-5.5F, -7.0F, -9.0F, 11, 14, 11);
/*  434 */     this.fneck_1.setRotationPoint(0.0F, -6.0F, -13.0F);
/*  435 */     this.fneck_1.setTextureSize(256, 256);
/*  436 */     this.fneck_1.mirror = true;
/*  437 */     setRotation(this.fneck_1, -0.8726646F, 0.0F, 0.0F);
/*  438 */     this.fneck_2 = new ModelRenderer(this, 71, 69);
/*  439 */     this.fneck_2.addBox(-4.0F, -5.0F, -8.0F, 8, 10, 9);
/*  440 */     this.fneck_2.setRotationPoint(0.0F, -12.0F, -17.0F);
/*  441 */     this.fneck_2.setTextureSize(256, 256);
/*  442 */     this.fneck_2.mirror = true;
/*  443 */     setRotation(this.fneck_2, -1.064651F, 0.0F, 0.0F);
/*  444 */     this.fneck_3 = new ModelRenderer(this, 102, 94);
/*  445 */     this.fneck_3.addBox(-3.0F, -4.0F, -17.0F, 6, 8, 18);
/*  446 */     this.fneck_3.setRotationPoint(0.0F, -19.0F, -21.0F);
/*  447 */     this.fneck_3.setTextureSize(256, 256);
/*  448 */     this.fneck_3.mirror = true;
/*  449 */     setRotation(this.fneck_3, -1.029744F, 0.0F, 0.0F);
/*  450 */     this.fabdomen = new ModelRenderer(this, 96, 39);
/*  451 */     this.fabdomen.addBox(-5.0F, -2.0F, 1.0F, 10, 11, 17);
/*  452 */     this.fabdomen.setRotationPoint(0.0F, -5.0F, 4.0F);
/*  453 */     this.fabdomen.setTextureSize(256, 256);
/*  454 */     this.fabdomen.mirror = true;
/*  455 */     setRotation(this.fabdomen, -0.6457718F, 0.0F, 0.0F);
/*  456 */     this.fhead = new ModelRenderer(this, 61, 49);
/*  457 */     this.fhead.addBox(-4.0F, -2.0F, -4.0F, 8, 8, 9);
/*  458 */     this.fhead.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  459 */     this.fhead.setTextureSize(256, 256);
/*  460 */     this.fhead.mirror = true;
/*  461 */     setRotation(this.fhead, -1.413717F, 0.0F, 0.0F);
/*  462 */     this.fupper_jaw = new ModelRenderer(this, 83, 89);
/*  463 */     this.fupper_jaw.addBox(-3.0F, 4.0F, -4.0F, 6, 13, 5);
/*  464 */     this.fupper_jaw.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  465 */     this.fupper_jaw.setTextureSize(256, 256);
/*  466 */     this.fupper_jaw.mirror = true;
/*  467 */     setRotation(this.fupper_jaw, -1.37881F, 0.0F, 0.0F);
/*  468 */     this.fbottom_jaw = new ModelRenderer(this, 85, 108);
/*  469 */     this.fbottom_jaw.addBox(-2.5F, -1.0F, -1.5F, 5, 12, 3);
/*  470 */     this.fbottom_jaw.setRotationPoint(0.0F, -28.0F, -34.0F);
/*  471 */     this.fbottom_jaw.setTextureSize(256, 256);
/*  472 */     this.fbottom_jaw.mirror = true;
/*  473 */     setRotation(this.fbottom_jaw, -1.413717F, 0.0F, 0.0F);
/*  474 */     this.fchest_ridge = new ModelRenderer(this, 113, 129);
/*  475 */     this.fchest_ridge.addBox(-2.0F, 7.0F, -3.0F, 4, 3, 17);
/*  476 */     this.fchest_ridge.setRotationPoint(0.0F, -2.0F, -7.0F);
/*  477 */     this.fchest_ridge.setTextureSize(256, 256);
/*  478 */     this.fchest_ridge.mirror = true;
/*  479 */     setRotation(this.fchest_ridge, -0.6283185F, 0.0F, 0.0F);
/*  480 */     this.fupper_sail_1 = new ModelRenderer(this, 76, 110);
/*  481 */     this.fupper_sail_1.addBox(-1.0F, -17.0F, -16.0F, 2, 14, 2);
/*  482 */     this.fupper_sail_1.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  483 */     this.fupper_sail_1.setTextureSize(256, 256);
/*  484 */     this.fupper_sail_1.mirror = true;
/*  485 */     setRotation(this.fupper_sail_1, 0.2443461F, 0.0F, 0.0F);
/*  486 */     this.fupper_sail2_ = new ModelRenderer(this, 63, 110);
/*  487 */     this.fupper_sail2_.addBox(-0.5F, -15.0F, -16.0F, 1, 12, 5);
/*  488 */     this.fupper_sail2_.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  489 */     this.fupper_sail2_.setTextureSize(256, 256);
/*  490 */     this.fupper_sail2_.mirror = true;
/*  491 */     setRotation(this.fupper_sail2_, 0.1396263F, 0.0F, 0.0F);
/*  492 */     this.fupper_sail3 = new ModelRenderer(this, 0, 82);
/*  493 */     this.fupper_sail3.addBox(0.0F, -1.5F, -18.0F, 0, 9, 13);
/*  494 */     this.fupper_sail3.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  495 */     this.fupper_sail3.setTextureSize(256, 256);
/*  496 */     this.fupper_sail3.mirror = true;
/*  497 */     setRotation(this.fupper_sail3, -0.7504916F, 0.0F, 0.0F);
/*  498 */     this.flower_sail1 = new ModelRenderer(this, 0, 2);
/*  499 */     this.flower_sail1.addBox(-1.0F, 0.0F, -10.0F, 2, 11, 2);
/*  500 */     this.flower_sail1.setRotationPoint(0.0F, -28.0F, -34.0F);
/*  501 */     this.flower_sail1.setTextureSize(256, 256);
/*  502 */     this.flower_sail1.mirror = true;
/*  503 */     setRotation(this.flower_sail1, 0.1919862F, 0.0F, 0.0F);
/*  504 */     this.flower_sail2 = new ModelRenderer(this, 52, 94);
/*  505 */     this.flower_sail2.addBox(-0.5F, 0.5F, -9.0F, 1, 9, 4);
/*  506 */     this.flower_sail2.setRotationPoint(0.0F, -28.0F, -34.0F);
/*  507 */     this.flower_sail2.setTextureSize(256, 256);
/*  508 */     this.flower_sail2.mirror = true;
/*  509 */     setRotation(this.flower_sail2, 0.296706F, 0.0F, 0.0F);
/*  510 */     this.flower_sail_3 = new ModelRenderer(this, 66, 90);
/*  511 */     this.flower_sail_3.addBox(0.0F, 1.5F, -4.0F, 0, 9, 7);
/*  512 */     this.flower_sail_3.setRotationPoint(0.0F, -28.0F, -34.0F);
/*  513 */     this.flower_sail_3.setTextureSize(256, 256);
/*  514 */     this.flower_sail_3.mirror = true;
/*  515 */     setRotation(this.flower_sail_3, -0.4886922F, 0.0F, 0.0F);
/*  516 */     this.feye_ridge_L = new ModelRenderer(this, 0, 68);
/*  517 */     this.feye_ridge_L.addBox(0.0F, -4.0F, -5.0F, 5, 2, 11);
/*  518 */     this.feye_ridge_L.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  519 */     this.feye_ridge_L.setTextureSize(256, 256);
/*  520 */     this.feye_ridge_L.mirror = true;
/*  521 */     setRotation(this.feye_ridge_L, 0.2094395F, 0.5585054F, 0.2268928F);
/*  522 */     this.feye_ridge_R = new ModelRenderer(this, 0, 68);
/*  523 */     this.feye_ridge_R.addBox(-5.0F, -4.0F, -5.0F, 5, 2, 11);
/*  524 */     this.feye_ridge_R.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  525 */     this.feye_ridge_R.setTextureSize(256, 256);
/*  526 */     this.feye_ridge_R.mirror = true;
/*  527 */     setRotation(this.feye_ridge_R, 0.2094395F, -0.5585054F, -0.2268928F);
/*  528 */     this.fanntena_1_L = new ModelRenderer(this, 0, 40);
/*  529 */     this.fanntena_1_L.addBox(3.0F, -4.2F, 5.0F, 2, 2, 5);
/*  530 */     this.fanntena_1_L.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  531 */     this.fanntena_1_L.setTextureSize(256, 256);
/*  532 */     this.fanntena_1_L.mirror = true;
/*  533 */     setRotation(this.fanntena_1_L, 0.2443461F, 0.3665191F, 0.2268928F);
/*  534 */     this.fanntena_1_R = new ModelRenderer(this, 0, 40);
/*  535 */     this.fanntena_1_R.addBox(-5.0F, -4.2F, 5.0F, 2, 2, 5);
/*  536 */     this.fanntena_1_R.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  537 */     this.fanntena_1_R.setTextureSize(256, 256);
/*  538 */     this.fanntena_1_R.mirror = true;
/*  539 */     setRotation(this.fanntena_1_R, 0.2443461F, -0.3665191F, -0.2268928F);
/*  540 */     this.fanntena_2_L = new ModelRenderer(this, 46, 91);
/*  541 */     this.fanntena_2_L.addBox(5.0F, -6.0F, 7.0F, 1, 1, 17);
/*  542 */     this.fanntena_2_L.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  543 */     this.fanntena_2_L.setTextureSize(256, 256);
/*  544 */     this.fanntena_2_L.mirror = true;
/*  545 */     setRotation(this.fanntena_2_L, 0.0698132F, 0.1396263F, 0.2268928F);
/*  546 */     this.fanntena_2_R = new ModelRenderer(this, 46, 91);
/*  547 */     this.fanntena_2_R.addBox(-6.0F, -6.0F, 7.0F, 1, 1, 17);
/*  548 */     this.fanntena_2_R.setRotationPoint(0.0F, -32.0F, -29.0F);
/*  549 */     this.fanntena_2_R.setTextureSize(256, 256);
/*  550 */     this.fanntena_2_R.mirror = true;
/*  551 */     setRotation(this.fanntena_2_R, 0.0698132F, -0.1396263F, -0.2268928F);
/*  552 */     this.farm_1_L = new ModelRenderer(this, 77, 150);
/*  553 */     this.farm_1_L.addBox(0.0F, -1.0F, -1.0F, 3, 18, 5);
/*  554 */     this.farm_1_L.setRotationPoint(8.0F, -8.0F, -10.0F);
/*  555 */     this.farm_1_L.setTextureSize(256, 256);
/*  556 */     this.farm_1_L.mirror = true;
/*  557 */     setRotation(this.farm_1_L, -0.0698132F, 0.0F, -0.7679449F);
/*  558 */     this.farm_2_L = new ModelRenderer(this, 102, 150);
/*  559 */     this.farm_2_L.addBox(-0.5F, 0.0F, -1.0F, 2, 24, 3);
/*  560 */     this.farm_2_L.setRotationPoint(20.0F, 3.0F, -10.0F);
/*  561 */     this.farm_2_L.setTextureSize(256, 256);
/*  562 */     this.farm_2_L.mirror = true;
/*  563 */     setRotation(this.farm_2_L, -0.4712389F, 0.0F, -0.4886922F);
/*  564 */     this.fwing_1_L = new ModelRenderer(this, 0, 33);
/*  565 */     this.fwing_1_L.addBox(1.5F, -1.0F, 3.0F, 1, 19, 15);
/*  566 */     this.fwing_1_L.setRotationPoint(8.0F, -8.0F, -10.0F);
/*  567 */     this.fwing_1_L.setTextureSize(256, 256);
/*  568 */     this.fwing_1_L.mirror = true;
/*  569 */     setRotation(this.fwing_1_L, -0.1745329F, -0.1919862F, -0.7504916F);
/*  570 */     this.fwing_2_L = new ModelRenderer(this, 33, 50);
/*  571 */     this.fwing_2_L.addBox(0.0F, -1.0F, 1.0F, 1, 23, 17);
/*  572 */     this.fwing_2_L.setRotationPoint(20.0F, 3.0F, -10.0F);
/*  573 */     this.fwing_2_L.setTextureSize(256, 256);
/*  574 */     this.fwing_2_L.mirror = true;
/*  575 */     setRotation(this.fwing_2_L, -0.5235988F, -0.0349066F, -0.4712389F);
/*  576 */     this.farm_1_R = new ModelRenderer(this, 77, 127);
/*  577 */     this.farm_1_R.addBox(-3.0F, -1.0F, -1.0F, 3, 18, 5);
/*  578 */     this.farm_1_R.setRotationPoint(-8.0F, -8.0F, -10.0F);
/*  579 */     this.farm_1_R.setTextureSize(256, 256);
/*  580 */     this.farm_1_R.mirror = true;
/*  581 */     setRotation(this.farm_1_R, -0.0698132F, 0.0F, 0.7679449F);
/*  582 */     this.farm_2_R = new ModelRenderer(this, 102, 123);
/*  583 */     this.farm_2_R.addBox(-1.5F, 0.0F, -1.0F, 2, 24, 3);
/*  584 */     this.farm_2_R.setRotationPoint(-20.0F, 3.0F, -10.0F);
/*  585 */     this.farm_2_R.setTextureSize(256, 256);
/*  586 */     this.farm_2_R.mirror = true;
/*  587 */     setRotation(this.farm_2_R, -0.4712389F, 0.0F, 0.4886922F);
/*  588 */     this.fwing_1_R = new ModelRenderer(this, 24, 150);
/*  589 */     this.fwing_1_R.addBox(-2.5F, -1.0F, 3.0F, 1, 19, 15);
/*  590 */     this.fwing_1_R.setRotationPoint(-8.0F, -8.0F, -10.0F);
/*  591 */     this.fwing_1_R.setTextureSize(256, 256);
/*  592 */     this.fwing_1_R.mirror = true;
/*  593 */     setRotation(this.fwing_1_R, -0.1745329F, 0.1919862F, 0.7504916F);
/*  594 */     this.fwing_2_R = new ModelRenderer(this, 150, 50);
/*  595 */     this.fwing_2_R.addBox(-1.0F, -1.0F, 0.0F, 1, 23, 17);
/*  596 */     this.fwing_2_R.setRotationPoint(-20.0F, 3.0F, -10.0F);
/*  597 */     this.fwing_2_R.setTextureSize(256, 256);
/*  598 */     this.fwing_2_R.mirror = true;
/*  599 */     setRotation(this.fwing_2_R, -0.5235988F, 0.0349066F, 0.4712389F);
/*  600 */     this.fleg_1_L = new ModelRenderer(this, 0, 104);
/*  601 */     this.fleg_1_L.addBox(0.0F, -3.0F, -4.0F, 3, 15, 7);
/*  602 */     this.fleg_1_L.setRotationPoint(5.0F, 5.0F, 10.0F);
/*  603 */     this.fleg_1_L.setTextureSize(256, 256);
/*  604 */     this.fleg_1_L.mirror = true;
/*  605 */     setRotation(this.fleg_1_L, -0.6108652F, 0.0F, -0.3316126F);
/*  606 */     this.fleg_1_R = new ModelRenderer(this, 0, 149);
/*  607 */     this.fleg_1_R.addBox(-3.0F, -3.0F, -4.0F, 3, 15, 7);
/*  608 */     this.fleg_1_R.setRotationPoint(-6.0F, 5.0F, 10.0F);
/*  609 */     this.fleg_1_R.setTextureSize(256, 256);
/*  610 */     this.fleg_1_R.mirror = true;
/*  611 */     setRotation(this.fleg_1_R, -0.6108652F, 0.0F, 0.3316126F);
/*  612 */     this.fleg_2_L = new ModelRenderer(this, 21, 108);
/*  613 */     this.fleg_2_L.addBox(1.0F, 0.0F, -3.0F, 2, 14, 4);
/*  614 */     this.fleg_2_L.setRotationPoint(8.0F, 13.0F, 6.0F);
/*  615 */     this.fleg_2_L.setTextureSize(256, 256);
/*  616 */     this.fleg_2_L.mirror = true;
/*  617 */     setRotation(this.fleg_2_L, 0.6108652F, 0.0F, -0.1745329F);
/*      */     
/*  619 */     this.fleg_2_R = new ModelRenderer(this, 21, 108);
/*  620 */     this.fleg_2_R.addBox(-2.0F, 0.0F, -3.0F, 2, 14, 4);
/*  621 */     this.fleg_2_R.setRotationPoint(-10.0F, 13.0F, 6.0F);
/*  622 */     this.fleg_2_R.setTextureSize(256, 256);
/*  623 */     this.fleg_2_R.mirror = true;
/*  624 */     setRotation(this.fleg_2_R, 0.6108652F, 0.0F, 0.1745329F);
/*      */     
/*  626 */     this.ffootL = new ModelRenderer(this, 50, 29);
/*  627 */     this.ffootL.addBox(-2.0F, -1.0F, -8.0F, 4, 2, 9);
/*  628 */     this.ffootL.setRotationPoint(12.0F, 24.0F, 11.0F);
/*  629 */     this.ffootL.setTextureSize(256, 256);
/*  630 */     this.ffootL.mirror = true;
/*  631 */     setRotation(this.ffootL, 0.0F, 0.0F, 0.0F);
/*      */     
/*  633 */     this.ffootR = new ModelRenderer(this, 50, 29);
/*  634 */     this.ffootR.addBox(-1.0F, 1.0F, -8.0F, 4, 2, 9);
/*  635 */     this.ffootR.setRotationPoint(-14.0F, 22.0F, 11.0F);
/*  636 */     this.ffootR.setTextureSize(256, 256);
/*  637 */     this.ffootR.mirror = true;
/*  638 */     setRotation(this.ffootR, 0.0F, 0.0F, 0.0F);
/*      */     
/*  640 */     this.fwing_3_L = new ModelRenderer(this, 0, 0);
/*  641 */     this.fwing_3_L.addBox(-7.5F, 0.0F, -5.0F, 16, 1, 26);
/*  642 */     this.fwing_3_L.setRotationPoint(-5.0F, 0.0F, 12.0F);
/*  643 */     this.fwing_3_L.setTextureSize(256, 256);
/*  644 */     this.fwing_3_L.mirror = true;
/*  645 */     setRotation(this.fwing_3_L, -0.4886922F, -0.5235988F, 0.4014257F);
/*  646 */     this.fwing_3_R = new ModelRenderer(this, 150, 0);
/*  647 */     this.fwing_3_R.addBox(-8.5F, 0.0F, -5.0F, 16, 1, 26);
/*  648 */     this.fwing_3_R.setRotationPoint(4.0F, 0.0F, 12.0F);
/*  649 */     this.fwing_3_R.setTextureSize(256, 256);
/*  650 */     this.fwing_3_R.mirror = true;
/*  651 */     setRotation(this.fwing_3_R, -0.4886922F, 0.5235988F, -0.4014257F);
/*  652 */     this.fwing_4_L = new ModelRenderer(this, 8, 117);
/*  653 */     this.fwing_4_L.addBox(-1.5F, -0.5F, -2.0F, 3, 1, 31);
/*  654 */     this.fwing_4_L.setRotationPoint(6.0F, 6.0F, 24.0F);
/*  655 */     this.fwing_4_L.setTextureSize(256, 256);
/*  656 */     this.fwing_4_L.mirror = true;
/*  657 */     setRotation(this.fwing_4_L, -0.6283185F, -0.0174533F, 0.0F);
/*  658 */     this.fwing_4_R = new ModelRenderer(this, 8, 117);
/*  659 */     this.fwing_4_R.addBox(-1.5F, -0.5F, -2.0F, 3, 1, 31);
/*  660 */     this.fwing_4_R.setRotationPoint(-7.0F, 6.0F, 24.0F);
/*  661 */     this.fwing_4_R.setTextureSize(256, 256);
/*  662 */     this.fwing_4_R.mirror = true;
/*  663 */     setRotation(this.fwing_4_R, -0.6283185F, 0.0174533F, 0.0F);
/*  664 */     this.fclaw_L = new ModelRenderer(this, 0, 129);
/*  665 */     this.fclaw_L.addBox(0.0F, -1.0F, -9.0F, 1, 2, 10);
/*  666 */     this.fclaw_L.setRotationPoint(30.0F, 23.0F, -20.0F);
/*  667 */     this.fclaw_L.setTextureSize(256, 256);
/*  668 */     this.fclaw_L.mirror = true;
/*  669 */     setRotation(this.fclaw_L, 0.0F, 0.1570796F, 0.0F);
/*  670 */     this.fclaw_R = new ModelRenderer(this, 0, 129);
/*  671 */     this.fclaw_R.addBox(0.0F, -1.0F, -9.0F, 1, 2, 10);
/*  672 */     this.fclaw_R.setRotationPoint(-31.0F, 23.0F, -20.0F);
/*  673 */     this.fclaw_R.setTextureSize(256, 256);
/*  674 */     this.fclaw_R.mirror = true;
/*  675 */     setRotation(this.fclaw_R, 0.0F, -0.1570796F, 0.0F);
/*  676 */     this.fclaw_L2 = new ModelRenderer(this, 18, 38);
/*  677 */     this.fclaw_L2.addBox(0.0F, -2.5F, -6.0F, 1, 2, 7);
/*  678 */     this.fclaw_L2.setRotationPoint(-30.0F, 23.0F, -28.0F);
/*  679 */     this.fclaw_L2.setTextureSize(256, 256);
/*  680 */     this.fclaw_L2.mirror = true;
/*  681 */     setRotation(this.fclaw_L2, 0.5061455F, -0.2792527F, 0.0F);
/*  682 */     this.fclaw_R_2 = new ModelRenderer(this, 18, 38);
/*  683 */     this.fclaw_R_2.addBox(-1.0F, -2.5F, -6.0F, 1, 2, 7);
/*  684 */     this.fclaw_R_2.setRotationPoint(30.0F, 23.0F, -28.0F);
/*  685 */     this.fclaw_R_2.setTextureSize(256, 256);
/*  686 */     this.fclaw_R_2.mirror = true;
/*  687 */     setRotation(this.fclaw_R_2, 0.5061455F, 0.2792527F, 0.0F);
/*  688 */     this.fwing_5_L = new ModelRenderer(this, 46, 10);
/*  689 */     this.fwing_5_L.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  690 */     this.fwing_5_L.setRotationPoint(31.0F, 21.0F, -19.0F);
/*  691 */     this.fwing_5_L.setTextureSize(256, 256);
/*  692 */     this.fwing_5_L.mirror = true;
/*  693 */     setRotation(this.fwing_5_L, 0.6806784F, 0.0523599F, -0.2792527F);
/*  694 */     this.fwing_6_L = new ModelRenderer(this, 46, 10);
/*  695 */     this.fwing_6_L.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  696 */     this.fwing_6_L.setRotationPoint(31.0F, 21.0F, -19.0F);
/*  697 */     this.fwing_6_L.setTextureSize(256, 256);
/*  698 */     this.fwing_6_L.mirror = true;
/*  699 */     setRotation(this.fwing_6_L, 0.4537856F, 0.2443461F, -0.3665191F);
/*  700 */     this.fwing_7_L = new ModelRenderer(this, 46, 10);
/*  701 */     this.fwing_7_L.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  702 */     this.fwing_7_L.setRotationPoint(-30.0F, 21.0F, -19.0F);
/*  703 */     this.fwing_7_L.setTextureSize(256, 256);
/*  704 */     this.fwing_7_L.mirror = true;
/*  705 */     setRotation(this.fwing_7_L, 0.1396263F, -0.3316126F, 0.4014257F);
/*  706 */     this.fwing_5_R = new ModelRenderer(this, 46, 10);
/*  707 */     this.fwing_5_R.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  708 */     this.fwing_5_R.setRotationPoint(-30.0F, 21.0F, -19.0F);
/*  709 */     this.fwing_5_R.setTextureSize(256, 256);
/*  710 */     this.fwing_5_R.mirror = true;
/*  711 */     setRotation(this.fwing_5_R, 0.6806784F, -0.0523599F, 0.2792527F);
/*  712 */     this.fwing_6_R = new ModelRenderer(this, 46, 10);
/*  713 */     this.fwing_6_R.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  714 */     this.fwing_6_R.setRotationPoint(-30.0F, 21.0F, -19.0F);
/*  715 */     this.fwing_6_R.setTextureSize(256, 256);
/*  716 */     this.fwing_6_R.mirror = true;
/*  717 */     setRotation(this.fwing_6_R, 0.4537856F, -0.2443461F, 0.3665191F);
/*  718 */     this.fwing_7_R = new ModelRenderer(this, 46, 10);
/*  719 */     this.fwing_7_R.addBox(-1.0F, -3.0F, -1.0F, 1, 8, 31);
/*  720 */     this.fwing_7_R.setRotationPoint(31.0F, 21.0F, -19.0F);
/*  721 */     this.fwing_7_R.setTextureSize(256, 256);
/*  722 */     this.fwing_7_R.mirror = true;
/*  723 */     setRotation(this.fwing_7_R, 0.1396263F, 0.3316126F, -0.4014257F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  729 */     Leon e = (Leon)entity;
/*  730 */     RenderInfo r = null;
/*  731 */     float newangle = 0.0F;
/*  732 */     float newangle2 = 0.0F;
/*  733 */     float newangle3 = 0.0F;
/*      */     
/*  735 */     float spd = 1.0F;
/*  736 */     float amp = 1.0F;
/*      */     
/*  738 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  739 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*      */ 
/*      */     
/*  742 */     if (f1 > 0.1D) {
/*  743 */       newangle = MathHelper.cos(f2 * 1.8F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*  744 */       newangle2 = MathHelper.cos(f2 * 0.9F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*      */     } else {
/*  746 */       newangle = 0.0F;
/*  747 */       newangle2 = MathHelper.cos(f2 * 0.9F * this.wingspeed) * 3.1415927F * 0.02F;
/*  748 */       if (e.isSitting()) newangle2 = 0.0F;
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  753 */     if (e.getActivity() == 0) {
/*      */       
/*  755 */       this.leg_1_L.rotateAngleX = -0.611F + newangle;
/*  756 */       this.leg_1_R.rotateAngleX = -0.611F - newangle;
/*  757 */       this.leg_2_L.rotateAngleX = 0.611F + newangle;
/*  758 */       this.leg_2_L.rotationPointZ = (float)(this.leg_1_L.rotationPointZ + Math.sin(this.leg_1_L.rotateAngleX) * 9.0D);
/*  759 */       this.leg_2_L.rotationPointY = (float)(this.leg_1_L.rotationPointY + Math.cos(this.leg_1_L.rotateAngleX) * 9.0D);
/*  760 */       this.leg_2_R.rotateAngleX = 0.611F - newangle;
/*  761 */       this.leg_2_R.rotationPointZ = (float)(this.leg_1_R.rotationPointZ + Math.sin(this.leg_1_R.rotateAngleX) * 9.0D);
/*  762 */       this.leg_2_R.rotationPointY = (float)(this.leg_1_R.rotationPointY + Math.cos(this.leg_1_R.rotateAngleX) * 9.0D);
/*  763 */       this.footL.rotationPointZ = (float)(this.leg_2_L.rotationPointZ + Math.sin(this.leg_2_L.rotateAngleX) * 13.0D);
/*  764 */       this.footL.rotationPointY = (float)(this.leg_2_L.rotationPointY + Math.cos(this.leg_2_L.rotateAngleX) * 13.0D);
/*  765 */       this.footR.rotationPointZ = (float)(this.leg_2_R.rotationPointZ + Math.sin(this.leg_2_R.rotateAngleX) * 11.0D);
/*  766 */       this.footR.rotationPointY = (float)(this.leg_2_R.rotationPointY + Math.cos(this.leg_2_R.rotateAngleX) * 11.0D);
/*      */ 
/*      */       
/*  769 */       this.wing_3_R.rotateAngleY = 0.523F - newangle / 10.0F;
/*  770 */       this.wing_3_L.rotateAngleY = -0.523F - newangle / 10.0F;
/*      */ 
/*      */       
/*  773 */       newangle /= 2.0F;
/*  774 */       this.arm_1_L.rotateAngleX = -0.07F - newangle;
/*  775 */       this.arm_1_R.rotateAngleX = -0.07F + newangle;
/*  776 */       this.wing_1_L.rotateAngleX = -0.17F - newangle;
/*  777 */       this.wing_1_R.rotateAngleX = -0.17F + newangle;
/*      */       
/*  779 */       this.arm_2_L.rotateAngleX = -0.471F - newangle;
/*  780 */       this.wing_2_L.rotateAngleX = -0.523F - newangle;
/*  781 */       this.wing_2_L.rotationPointZ = (float)(this.arm_1_L.rotationPointZ + Math.sin(this.arm_1_L.rotateAngleX) * 11.0D);
/*  782 */       this.wing_2_L.rotationPointY = (float)(this.arm_1_L.rotationPointY + Math.cos(this.arm_1_L.rotateAngleX) * 11.0D);
/*      */       
/*  784 */       this.wing_5_L.rotateAngleX = 0.68F + newangle2 / 2.0F;
/*  785 */       this.wing_6_L.rotateAngleX = 0.453F + newangle2 / 4.0F;
/*  786 */       this.wing_7_R.rotateAngleX = 0.119F + newangle2 / 8.0F;
/*      */       
/*  788 */       this.wing_5_L.rotationPointZ = (float)(this.arm_2_L.rotationPointZ + Math.sin(this.arm_2_L.rotateAngleX) * 20.0D);
/*  789 */       this.wing_5_L.rotationPointY = (float)(this.arm_2_L.rotationPointY + Math.cos(this.arm_2_L.rotateAngleX) * 20.0D);
/*  790 */       this.wing_6_L.rotationPointZ = this.wing_5_L.rotationPointZ;
/*  791 */       this.wing_6_L.rotationPointY = this.wing_5_L.rotationPointY;
/*  792 */       this.wing_7_R.rotationPointZ = this.wing_5_L.rotationPointZ;
/*  793 */       this.wing_7_R.rotationPointY = this.wing_5_L.rotationPointY;
/*  794 */       this.wing_5_L.rotationPointZ--;
/*  795 */       this.wing_5_L.rotationPointZ -= 9.0F;
/*  796 */       this.wing_5_L.rotationPointY += 2.0F;
/*  797 */       this.wing_5_L.rotationPointY += 2.0F;
/*      */ 
/*      */       
/*  800 */       this.arm_2_R.rotateAngleX = -0.471F + newangle;
/*  801 */       this.wing_2_R.rotateAngleX = -0.523F + newangle;
/*  802 */       this.wing_2_R.rotationPointZ = (float)(this.arm_1_R.rotationPointZ + Math.sin(this.arm_1_R.rotateAngleX) * 11.0D);
/*  803 */       this.wing_2_R.rotationPointY = (float)(this.arm_1_R.rotationPointY + Math.cos(this.arm_1_R.rotateAngleX) * 11.0D);
/*      */       
/*  805 */       this.wing_5_R.rotateAngleX = 0.68F + newangle2 / 2.0F;
/*  806 */       this.wing_6_R.rotateAngleX = 0.453F + newangle2 / 4.0F;
/*  807 */       this.wing_7_L.rotateAngleX = 0.119F + newangle2 / 8.0F;
/*      */       
/*  809 */       this.wing_5_R.rotationPointZ = (float)(this.arm_2_R.rotationPointZ + Math.sin(this.arm_2_R.rotateAngleX) * 20.0D);
/*  810 */       this.wing_5_R.rotationPointY = (float)(this.arm_2_R.rotationPointY + Math.cos(this.arm_2_R.rotateAngleX) * 20.0D);
/*  811 */       this.wing_6_R.rotationPointZ = this.wing_5_R.rotationPointZ;
/*  812 */       this.wing_6_R.rotationPointY = this.wing_5_R.rotationPointY;
/*  813 */       this.wing_7_L.rotationPointZ = this.wing_5_R.rotationPointZ;
/*  814 */       this.wing_7_L.rotationPointY = this.wing_5_R.rotationPointY;
/*  815 */       this.wing_5_R.rotationPointZ--;
/*  816 */       this.wing_5_R.rotationPointZ -= 9.0F;
/*  817 */       this.wing_5_R.rotationPointY += 2.0F;
/*  818 */       this.wing_5_R.rotationPointY += 2.0F;
/*      */ 
/*      */       
/*  821 */       newangle2 = MathHelper.cos(f2 * 0.6F * this.wingspeed) * 3.1415927F * 0.02F;
/*  822 */       this.chest.rotateAngleX = -0.436F + newangle2 / 8.0F;
/*  823 */       this.chest_ridge.rotateAngleX = this.chest.rotateAngleX;
/*      */ 
/*      */       
/*  826 */       this.bottom_jaw.rotateAngleX = -1.308F + newangle2 / 2.0F;
/*  827 */       this.lower_sail1.rotateAngleX = 0.297F + newangle2 / 2.0F;
/*  828 */       this.lower_sail2.rotateAngleX = 0.384F + newangle2 / 2.0F;
/*  829 */       this.lower_sail_3.rotateAngleX = -0.384F + newangle2 / 2.0F;
/*      */ 
/*      */ 
/*      */       
/*  833 */       newangle = (float)Math.toRadians(f3) * 0.5F;
/*  834 */       this.upper_sail3.rotateAngleY = newangle;
/*  835 */       this.eye_ridge_L.rotateAngleY = 0.558F + newangle;
/*  836 */       this.anntena_1_L.rotateAngleY = 0.366F + newangle;
/*  837 */       this.anntena_2_L.rotateAngleY = 0.139F + newangle;
/*  838 */       this.eye_ridge_R.rotateAngleY = -0.558F + newangle;
/*  839 */       this.anntena_1_R.rotateAngleY = -0.366F + newangle;
/*  840 */       this.anntena_2_R.rotateAngleY = -0.139F + newangle;
/*      */       
/*  842 */       this.lower_sail_3.rotateAngleY = newangle;
/*  843 */       this.bottom_jaw.rotationPointZ = (float)(this.head.rotationPointZ - Math.cos(newangle) * 5.0D);
/*  844 */       this.bottom_jaw.rotationPointX = (float)(this.head.rotationPointX - Math.sin(newangle) * 5.0D);
/*      */ 
/*      */       
/*  847 */       this.chest.render(f5);
/*  848 */       this.neck_1.render(f5);
/*  849 */       this.neck_2.render(f5);
/*  850 */       this.neck_3.render(f5);
/*  851 */       this.abdomen.render(f5);
/*  852 */       this.head.render(f5);
/*  853 */       this.upper_jaw.render(f5);
/*  854 */       this.bottom_jaw.render(f5);
/*  855 */       this.chest_ridge.render(f5);
/*  856 */       this.upper_sail_1.render(f5);
/*  857 */       this.upper_sail2_.render(f5);
/*  858 */       this.upper_sail3.render(f5);
/*  859 */       this.lower_sail1.render(f5);
/*  860 */       this.lower_sail2.render(f5);
/*  861 */       this.lower_sail_3.render(f5);
/*  862 */       this.eye_ridge_L.render(f5);
/*  863 */       this.eye_ridge_R.render(f5);
/*  864 */       this.anntena_1_L.render(f5);
/*  865 */       this.anntena_1_R.render(f5);
/*  866 */       this.anntena_2_L.render(f5);
/*  867 */       this.anntena_2_R.render(f5);
/*  868 */       this.arm_1_L.render(f5);
/*  869 */       this.arm_2_L.render(f5);
/*  870 */       this.wing_1_L.render(f5);
/*  871 */       this.wing_2_L.render(f5);
/*  872 */       this.arm_1_R.render(f5);
/*  873 */       this.arm_2_R.render(f5);
/*  874 */       this.wing_1_R.render(f5);
/*  875 */       this.wing_2_R.render(f5);
/*  876 */       this.leg_1_L.render(f5);
/*  877 */       this.leg_1_R.render(f5);
/*  878 */       this.leg_2_L.render(f5);
/*  879 */       this.leg_2_R.render(f5);
/*  880 */       this.footL.render(f5);
/*  881 */       this.footR.render(f5);
/*  882 */       this.wing_3_L.render(f5);
/*  883 */       this.wing_3_R.render(f5);
/*  884 */       this.wing_4_L.render(f5);
/*  885 */       this.wing_4_R.render(f5);
/*  886 */       this.claw_L.render(f5);
/*  887 */       this.claw_R.render(f5);
/*  888 */       this.claw_L2.render(f5);
/*  889 */       this.claw_R_2.render(f5);
/*  890 */       this.wing_5_L.render(f5);
/*  891 */       this.wing_6_L.render(f5);
/*  892 */       this.wing_7_L.render(f5);
/*  893 */       this.wing_5_R.render(f5);
/*  894 */       this.wing_6_R.render(f5);
/*  895 */       this.wing_7_R.render(f5);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  900 */       if (e.getAttacking() != 0) {
/*  901 */         spd = 1.7F;
/*  902 */         amp = 1.4F;
/*      */       } 
/*      */       
/*  905 */       newangle2 = MathHelper.cos(f2 * 1.6F * this.wingspeed * spd) * 3.1415927F * 0.06F;
/*  906 */       this.fchest.rotateAngleX = newangle2 / 8.0F;
/*  907 */       this.fchest_ridge.rotateAngleX = -0.18F + this.fchest.rotateAngleX;
/*      */ 
/*      */       
/*  910 */       if (e.getBeingRidden() == 0) {
/*  911 */         this.fchest.rotationPointY = (float)(-2.0D + Math.sin(newangle2) * 10.0D * amp);
/*      */       } else {
/*  913 */         this.fchest.rotationPointY = -2.0F;
/*      */       } 
/*  915 */       this.fchest_ridge.rotationPointY = this.fchest.rotationPointY;
/*  916 */       this.fabdomen.rotateAngleX = 0.0F;
/*  917 */       this.fabdomen.rotationPointZ = (float)(this.fchest.rotationPointZ + Math.cos(this.fchest.rotateAngleX) * 8.0D);
/*  918 */       this.fabdomen.rotationPointY = (float)(this.fchest.rotationPointY - Math.sin(this.fchest.rotateAngleX) * 8.0D - 6.0D);
/*      */ 
/*      */       
/*  921 */       this.fwing_3_R.rotationPointY = this.fabdomen.rotationPointY;
/*  922 */       this.fwing_3_L.rotationPointY = this.fabdomen.rotationPointY;
/*  923 */       this.fwing_3_R.rotateAngleX = this.fwing_3_R.rotateAngleZ = 0.0F;
/*  924 */       this.fwing_3_L.rotateAngleX = this.fwing_3_L.rotateAngleZ = 0.0F;
/*  925 */       this.fwing_3_R.rotateAngleY = 0.785F;
/*  926 */       this.fwing_3_L.rotateAngleY = -0.785F;
/*  927 */       this.fabdomen.rotationPointY += 0.55F;
/*  928 */       this.fabdomen.rotationPointY += 0.55F;
/*  929 */       this.fabdomen.rotationPointZ += 26.0F;
/*  930 */       this.fabdomen.rotationPointZ += 26.0F;
/*  931 */       this.fwing_4_R.rotationPointX = this.fabdomen.rotationPointZ + 8.0F;
/*  932 */       this.fwing_4_L.rotationPointX = this.fabdomen.rotationPointZ - 9.0F;
/*      */       
/*  934 */       this.fwing_4_R.rotateAngleX = newangle2 / 10.0F;
/*  935 */       this.fwing_4_L.rotateAngleX = -newangle2 / 10.0F;
/*      */ 
/*      */ 
/*      */       
/*  939 */       if (e.getAttacking() == 0) {
/*  940 */         newangle = 1.5707964F;
/*  941 */         this.fabdomen.rotationPointY += 5.0F;
/*  942 */         this.fabdomen.rotationPointY += 5.0F;
/*      */         
/*  944 */         this.fleg_1_L.rotateAngleX = -0.1F + newangle;
/*  945 */         this.fleg_1_R.rotateAngleX = -0.1F + newangle;
/*  946 */         this.fleg_2_L.rotateAngleX = 0.1F + newangle;
/*  947 */         this.fleg_2_L.rotationPointZ = (float)(this.fleg_1_L.rotationPointZ + Math.sin(this.fleg_1_L.rotateAngleX) * 9.0D);
/*  948 */         this.fleg_2_L.rotationPointY = (float)(this.fleg_1_L.rotationPointY + Math.cos(this.fleg_1_L.rotateAngleX) * 9.0D);
/*  949 */         this.fleg_2_R.rotateAngleX = 0.1F + newangle;
/*  950 */         this.fleg_2_R.rotationPointZ = (float)(this.fleg_1_R.rotationPointZ + Math.sin(this.fleg_1_R.rotateAngleX) * 9.0D);
/*  951 */         this.fleg_2_R.rotationPointY = (float)(this.fleg_1_R.rotationPointY + Math.cos(this.fleg_1_R.rotateAngleX) * 9.0D);
/*  952 */         this.ffootL.rotationPointZ = (float)(this.fleg_2_L.rotationPointZ + Math.sin(this.fleg_2_L.rotateAngleX) * 13.0D);
/*  953 */         this.ffootL.rotationPointY = (float)(this.fleg_2_L.rotationPointY + Math.cos(this.fleg_2_L.rotateAngleX) * 13.0D);
/*  954 */         this.ffootR.rotationPointZ = (float)(this.fleg_2_R.rotationPointZ + Math.sin(this.fleg_2_R.rotateAngleX) * 11.0D);
/*  955 */         this.ffootR.rotationPointY = (float)(this.fleg_2_R.rotationPointY + Math.cos(this.fleg_2_R.rotateAngleX) * 11.0D);
/*  956 */         this.ffootL.rotateAngleX = 3.1415927F;
/*  957 */         this.ffootR.rotateAngleX = 3.1415927F;
/*  958 */         this.fleg_2_L.rotationPointX = this.fleg_1_L.rotationPointX;
/*  959 */         this.ffootL.rotationPointX = this.fleg_1_L.rotationPointX;
/*  960 */         this.fleg_2_R.rotationPointX = this.fleg_1_R.rotationPointX;
/*  961 */         this.ffootR.rotationPointX = this.fleg_1_R.rotationPointX;
/*      */       }
/*      */       else {
/*      */         
/*  965 */         newangle = -0.7853982F;
/*  966 */         newangle3 = MathHelper.cos(f2 * 3.6F * this.wingspeed) * 3.1415927F * 0.1F;
/*  967 */         this.fabdomen.rotationPointY += 5.0F;
/*  968 */         this.fabdomen.rotationPointY += 5.0F;
/*      */         
/*  970 */         this.fleg_1_L.rotateAngleX = -0.1F + newangle + newangle3;
/*  971 */         this.fleg_1_R.rotateAngleX = -0.1F + newangle - newangle3;
/*  972 */         this.fleg_2_L.rotateAngleX = 0.2F + newangle + newangle3 * 3.0F / 2.0F;
/*  973 */         this.fleg_2_L.rotationPointZ = (float)(this.fleg_1_L.rotationPointZ + Math.sin(this.fleg_1_L.rotateAngleX) * 9.0D);
/*  974 */         this.fleg_2_L.rotationPointY = (float)(this.fleg_1_L.rotationPointY + Math.cos(this.fleg_1_L.rotateAngleX) * 9.0D);
/*  975 */         this.fleg_2_R.rotateAngleX = 0.2F + newangle - newangle3 * 3.0F / 2.0F;
/*  976 */         this.fleg_2_R.rotationPointZ = (float)(this.fleg_1_R.rotationPointZ + Math.sin(this.fleg_1_R.rotateAngleX) * 9.0D);
/*  977 */         this.fleg_2_R.rotationPointY = (float)(this.fleg_1_R.rotationPointY + Math.cos(this.fleg_1_R.rotateAngleX) * 9.0D);
/*  978 */         this.ffootL.rotationPointZ = (float)(this.fleg_2_L.rotationPointZ + Math.sin(this.fleg_2_L.rotateAngleX) * 13.0D);
/*  979 */         this.ffootL.rotationPointY = (float)(this.fleg_2_L.rotationPointY + Math.cos(this.fleg_2_L.rotateAngleX) * 13.0D);
/*  980 */         this.ffootR.rotationPointZ = (float)(this.fleg_2_R.rotationPointZ + Math.sin(this.fleg_2_R.rotateAngleX) * 11.0D);
/*  981 */         this.ffootR.rotationPointY = (float)(this.fleg_2_R.rotationPointY + Math.cos(this.fleg_2_R.rotateAngleX) * 11.0D);
/*  982 */         this.ffootL.rotateAngleX = -0.7853982F + newangle3 * 2.0F;
/*  983 */         this.ffootR.rotateAngleX = -0.7853982F - newangle3 * 2.0F;
/*  984 */         this.fleg_2_L.rotationPointX = 7.0F;
/*  985 */         this.ffootL.rotationPointX = 11.0F;
/*  986 */         this.fleg_2_R.rotationPointX = -9.0F;
/*  987 */         this.ffootR.rotationPointX = -13.0F;
/*      */       } 
/*      */ 
/*      */       
/*  991 */       newangle = MathHelper.cos(f2 * 1.6F * this.wingspeed * spd) * 3.1415927F * 0.26F * amp;
/*      */       
/*  993 */       this.farm_1_L.rotateAngleZ = (float)(-1.5707963267948966D - newangle);
/*  994 */       this.farm_1_R.rotateAngleZ = (float)(1.5707963267948966D + newangle);
/*  995 */       this.fwing_1_L.rotateAngleZ = (float)(-1.5707963267948966D - newangle);
/*  996 */       this.fwing_1_R.rotateAngleZ = (float)(1.5707963267948966D + newangle);
/*      */       
/*  998 */       this.farm_2_L.rotateAngleZ = (float)(-1.5707963267948966D - (newangle * 1.3F));
/*  999 */       this.fwing_2_L.rotateAngleZ = (float)(-1.5707963267948966D - (newangle * 1.3F));
/* 1000 */       this.fwing_2_L.rotationPointX = (float)(this.farm_1_L.rotationPointX + Math.cos(newangle) * 14.0D);
/* 1001 */       this.fwing_2_L.rotationPointY = (float)(this.farm_1_L.rotationPointY - Math.sin(newangle) * 14.0D);
/*      */       
/* 1003 */       this.fwing_5_L.rotationPointX = (float)(this.farm_2_L.rotationPointX + Math.cos((newangle * 1.3F)) * 20.0D);
/* 1004 */       this.fwing_5_L.rotationPointY = (float)(this.farm_2_L.rotationPointY - Math.sin((newangle * 1.3F)) * 20.0D);
/* 1005 */       this.fwing_6_L.rotationPointX = this.fwing_5_L.rotationPointX;
/* 1006 */       this.fwing_6_L.rotationPointY = this.fwing_5_L.rotationPointY;
/* 1007 */       this.fwing_7_R.rotationPointX = this.fwing_5_L.rotationPointX;
/* 1008 */       this.fwing_7_R.rotationPointY = this.fwing_5_L.rotationPointY;
/* 1009 */       this.fclaw_L.rotationPointX = this.fwing_5_L.rotationPointX;
/* 1010 */       this.fclaw_R_2.rotationPointX = this.fwing_5_L.rotationPointX;
/* 1011 */       this.fclaw_L.rotationPointY = this.fwing_5_L.rotationPointY;
/* 1012 */       this.fclaw_R_2.rotationPointY = this.fwing_5_L.rotationPointY;
/*      */       
/* 1014 */       this.fwing_5_L.rotateAngleZ = (float)(-1.5707963267948966D - (newangle * 1.65F));
/* 1015 */       this.fwing_6_L.rotateAngleZ = (float)(-1.5707963267948966D - (newangle * 1.65F));
/* 1016 */       this.fwing_7_R.rotateAngleZ = (float)(-1.5707963267948966D - (newangle * 1.65F));
/*      */       
/* 1018 */       this.fwing_7_R.rotateAngleX = -1.5707964F;
/* 1019 */       this.fwing_6_L.rotateAngleX = -1.1780972F;
/* 1020 */       this.fwing_5_L.rotateAngleX = -0.7853982F;
/*      */ 
/*      */       
/* 1023 */       this.farm_2_R.rotateAngleZ = (float)(1.5707963267948966D + (newangle * 1.3F));
/* 1024 */       this.fwing_2_R.rotateAngleZ = (float)(1.5707963267948966D + (newangle * 1.3F));
/* 1025 */       this.fwing_2_R.rotationPointX = (float)(this.farm_1_R.rotationPointX - Math.cos(newangle) * 14.0D);
/* 1026 */       this.fwing_2_R.rotationPointY = (float)(this.farm_1_R.rotationPointY - Math.sin(newangle) * 14.0D);
/*      */       
/* 1028 */       this.fwing_5_R.rotationPointX = (float)(this.farm_2_R.rotationPointX - Math.cos((newangle * 1.3F)) * 20.0D);
/* 1029 */       this.fwing_5_R.rotationPointY = (float)(this.farm_2_R.rotationPointY - Math.sin((newangle * 1.3F)) * 20.0D);
/* 1030 */       this.fwing_6_R.rotationPointX = this.fwing_5_R.rotationPointX;
/* 1031 */       this.fwing_6_R.rotationPointY = this.fwing_5_R.rotationPointY;
/* 1032 */       this.fwing_7_L.rotationPointX = this.fwing_5_R.rotationPointX;
/* 1033 */       this.fwing_7_L.rotationPointY = this.fwing_5_R.rotationPointY;
/* 1034 */       this.fclaw_R.rotationPointX = this.fwing_5_R.rotationPointX;
/* 1035 */       this.fclaw_L2.rotationPointX = this.fwing_5_R.rotationPointX;
/* 1036 */       this.fclaw_R.rotationPointY = this.fwing_5_R.rotationPointY;
/* 1037 */       this.fclaw_L2.rotationPointY = this.fwing_5_R.rotationPointY;
/*      */       
/* 1039 */       this.fwing_5_R.rotateAngleZ = (float)(1.5707963267948966D + (newangle * 1.65F));
/* 1040 */       this.fwing_6_R.rotateAngleZ = (float)(1.5707963267948966D + (newangle * 1.65F));
/* 1041 */       this.fwing_7_L.rotateAngleZ = (float)(1.5707963267948966D + (newangle * 1.65F));
/*      */       
/* 1043 */       this.fwing_7_L.rotateAngleX = -1.5707964F;
/* 1044 */       this.fwing_6_R.rotateAngleX = -1.1780972F;
/* 1045 */       this.fwing_5_R.rotateAngleX = -0.7853982F;
/*      */ 
/*      */ 
/*      */       
/* 1049 */       this.fneck_1.rotateAngleX = -newangle / 12.0F;
/* 1050 */       this.fneck_1.rotationPointZ = (float)(this.fchest.rotationPointZ - Math.cos(this.fchest.rotateAngleX) * 10.0D);
/* 1051 */       this.fneck_1.rotationPointY = (float)(this.fchest.rotationPointY + Math.sin(this.fchest.rotateAngleX) * 8.0D - 1.0D);
/*      */       
/* 1053 */       this.fneck_2.rotateAngleX = -newangle / 10.0F;
/* 1054 */       this.fneck_2.rotationPointZ = (float)(this.fneck_1.rotationPointZ - Math.cos(this.fneck_1.rotateAngleX) * 7.0D);
/* 1055 */       this.fneck_2.rotationPointY = (float)(this.fneck_1.rotationPointY + Math.sin(this.fneck_1.rotateAngleX) * 6.0D - 1.0D);
/*      */       
/* 1057 */       this.fneck_3.rotateAngleX = -newangle / 8.0F;
/* 1058 */       this.fneck_3.rotationPointZ = (float)(this.fneck_2.rotationPointZ - Math.cos(this.fneck_2.rotateAngleX) * 7.0D);
/* 1059 */       this.fneck_3.rotationPointY = (float)(this.fneck_2.rotationPointY + Math.sin(this.fneck_2.rotateAngleX) * 5.0D);
/*      */ 
/*      */       
/* 1062 */       this.fhead.rotationPointZ = (float)(this.fneck_3.rotationPointZ - Math.cos(this.fneck_3.rotateAngleX) * 16.0D);
/* 1063 */       this.fhead.rotationPointY = (float)(this.fneck_3.rotationPointY + Math.sin(this.fneck_3.rotateAngleX) * 15.0D);
/*      */       
/* 1065 */       this.fupper_jaw.rotationPointZ = this.fhead.rotationPointZ;
/* 1066 */       this.fupper_sail_1.rotationPointZ = this.fhead.rotationPointZ;
/* 1067 */       this.fupper_sail2_.rotationPointZ = this.fhead.rotationPointZ;
/* 1068 */       this.fupper_sail3.rotationPointZ = this.fhead.rotationPointZ;
/* 1069 */       this.feye_ridge_L.rotationPointZ = this.fhead.rotationPointZ;
/* 1070 */       this.fanntena_1_L.rotationPointZ = this.fhead.rotationPointZ;
/* 1071 */       this.fanntena_2_L.rotationPointZ = this.fhead.rotationPointZ;
/* 1072 */       this.feye_ridge_R.rotationPointZ = this.fhead.rotationPointZ;
/* 1073 */       this.fanntena_1_R.rotationPointZ = this.fhead.rotationPointZ;
/* 1074 */       this.fanntena_2_R.rotationPointZ = this.fhead.rotationPointZ;
/*      */       
/* 1076 */       this.fhead.rotationPointZ -= 5.0F;
/* 1077 */       this.fhead.rotationPointZ -= 5.0F;
/* 1078 */       this.fhead.rotationPointZ -= 5.0F;
/* 1079 */       this.fhead.rotationPointZ -= 5.0F;
/*      */       
/* 1081 */       this.fupper_jaw.rotationPointY = this.fhead.rotationPointY;
/* 1082 */       this.fupper_sail_1.rotationPointY = this.fhead.rotationPointY;
/* 1083 */       this.fupper_sail2_.rotationPointY = this.fhead.rotationPointY;
/* 1084 */       this.fupper_sail3.rotationPointY = this.fhead.rotationPointY;
/* 1085 */       this.feye_ridge_L.rotationPointY = this.fhead.rotationPointY;
/* 1086 */       this.fanntena_1_L.rotationPointY = this.fhead.rotationPointY;
/* 1087 */       this.fanntena_2_L.rotationPointY = this.fhead.rotationPointY;
/* 1088 */       this.feye_ridge_R.rotationPointY = this.fhead.rotationPointY;
/* 1089 */       this.fanntena_1_R.rotationPointY = this.fhead.rotationPointY;
/* 1090 */       this.fanntena_2_R.rotationPointY = this.fhead.rotationPointY;
/*      */       
/* 1092 */       this.fhead.rotationPointY += 4.0F;
/* 1093 */       this.fhead.rotationPointY += 4.0F;
/* 1094 */       this.fhead.rotationPointY += 4.0F;
/* 1095 */       this.fhead.rotationPointY += 4.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1100 */       if (e.getBeingRidden() == 0) {
/* 1101 */         newangle = (float)Math.toRadians(f3) * 0.5F;
/*      */       } else {
/* 1103 */         r = e.getRenderInfo();
/* 1104 */         f3 = (e.prevRotationYaw - e.rotationYaw) * 8.0F;
/* 1105 */         f3 = -f3;
/* 1106 */         r.rf1 += (f3 - r.rf1) / 60.0F;
/* 1107 */         if (r.rf1 > 50.0F) r.rf1 = 50.0F; 
/* 1108 */         if (r.rf1 < -50.0F) r.rf1 = -50.0F; 
/* 1109 */         f3 = r.rf1;
/* 1110 */         e.setRenderInfo(r);
/* 1111 */         newangle = (float)Math.toRadians(f3) * 0.5F;
/*      */       } 
/* 1113 */       this.fupper_sail3.rotateAngleY = newangle;
/* 1114 */       this.feye_ridge_L.rotateAngleY = 0.558F + newangle;
/* 1115 */       this.fanntena_1_L.rotateAngleY = 0.366F + newangle;
/* 1116 */       this.fanntena_2_L.rotateAngleY = 0.139F + newangle;
/* 1117 */       this.feye_ridge_R.rotateAngleY = -0.558F + newangle;
/* 1118 */       this.fanntena_1_R.rotateAngleY = -0.366F + newangle;
/* 1119 */       this.fanntena_2_R.rotateAngleY = -0.139F + newangle;
/*      */       
/* 1121 */       this.flower_sail_3.rotateAngleY = newangle;
/* 1122 */       this.fbottom_jaw.rotationPointZ = (float)(this.fhead.rotationPointZ - Math.cos(newangle) * 5.0D);
/* 1123 */       this.fbottom_jaw.rotationPointX = (float)(this.fhead.rotationPointX - Math.sin(newangle) * 5.0D);
/*      */ 
/*      */       
/* 1126 */       float tf1 = 1.605F;
/* 1127 */       float tf2 = 1.6919999F;
/* 1128 */       float tf3 = 0.92399997F;
/*      */       
/* 1130 */       if (e.getAttacking() == 0) {
/* 1131 */         this.fbottom_jaw.rotateAngleX = -1.308F + newangle2 / 2.0F;
/*      */       } else {
/* 1133 */         newangle2 = MathHelper.cos(f2 * 2.6F * this.wingspeed) * 3.1415927F * 0.16F;
/* 1134 */         this.fbottom_jaw.rotateAngleX = -0.9F + newangle2;
/*      */       } 
/*      */       
/* 1137 */       this.fbottom_jaw.rotateAngleX += tf1;
/* 1138 */       this.fbottom_jaw.rotateAngleX += tf2;
/* 1139 */       this.fbottom_jaw.rotateAngleX += tf3;
/*      */ 
/*      */ 
/*      */       
/* 1143 */       this.fchest.render(f5);
/* 1144 */       this.fneck_1.render(f5);
/* 1145 */       this.fneck_2.render(f5);
/* 1146 */       this.fneck_3.render(f5);
/* 1147 */       this.fabdomen.render(f5);
/* 1148 */       this.fhead.render(f5);
/* 1149 */       this.fupper_jaw.render(f5);
/* 1150 */       this.fbottom_jaw.render(f5);
/* 1151 */       this.fchest_ridge.render(f5);
/* 1152 */       this.fupper_sail_1.render(f5);
/* 1153 */       this.fupper_sail2_.render(f5);
/* 1154 */       this.fupper_sail3.render(f5);
/* 1155 */       this.flower_sail1.render(f5);
/* 1156 */       this.flower_sail2.render(f5);
/* 1157 */       this.flower_sail_3.render(f5);
/* 1158 */       this.feye_ridge_L.render(f5);
/* 1159 */       this.feye_ridge_R.render(f5);
/* 1160 */       this.fanntena_1_L.render(f5);
/* 1161 */       this.fanntena_1_R.render(f5);
/* 1162 */       this.fanntena_2_L.render(f5);
/* 1163 */       this.fanntena_2_R.render(f5);
/* 1164 */       this.farm_1_L.render(f5);
/* 1165 */       this.farm_2_L.render(f5);
/* 1166 */       this.fwing_1_L.render(f5);
/* 1167 */       this.fwing_2_L.render(f5);
/* 1168 */       this.farm_1_R.render(f5);
/* 1169 */       this.farm_2_R.render(f5);
/* 1170 */       this.fwing_1_R.render(f5);
/* 1171 */       this.fwing_2_R.render(f5);
/* 1172 */       this.fleg_1_L.render(f5);
/* 1173 */       this.fleg_1_R.render(f5);
/* 1174 */       this.fleg_2_L.render(f5);
/* 1175 */       this.fleg_2_R.render(f5);
/* 1176 */       this.ffootL.render(f5);
/* 1177 */       this.ffootR.render(f5);
/* 1178 */       this.fwing_3_L.render(f5);
/* 1179 */       this.fwing_3_R.render(f5);
/* 1180 */       this.fwing_4_L.render(f5);
/* 1181 */       this.fwing_4_R.render(f5);
/* 1182 */       this.fclaw_L.render(f5);
/* 1183 */       this.fclaw_R.render(f5);
/* 1184 */       this.fclaw_L2.render(f5);
/* 1185 */       this.fclaw_R_2.render(f5);
/* 1186 */       this.fwing_5_L.render(f5);
/* 1187 */       this.fwing_6_L.render(f5);
/* 1188 */       this.fwing_7_L.render(f5);
/* 1189 */       this.fwing_5_R.render(f5);
/* 1190 */       this.fwing_6_R.render(f5);
/* 1191 */       this.fwing_7_R.render(f5);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 1198 */     model.rotateAngleX = x;
/* 1199 */     model.rotateAngleY = y;
/* 1200 */     model.rotateAngleZ = z;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 1205 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelLeon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
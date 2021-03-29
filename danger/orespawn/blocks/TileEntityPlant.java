/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TileEntityPlant
/*    */   extends TileEntity
/*    */ {
/* 14 */   private int age = 0;
/* 15 */   private int phase = 1;
/* 16 */   private int heightContribution = OreSpawnMain.OreSpawnRand.nextInt(5) + 3;
/*    */ 
/*    */   
/*    */   public int getAge() {
/* 20 */     return this.age;
/*    */   }
/*    */   
/*    */   public void setAge(int x) {
/* 24 */     this.age = x;
/*    */   }
/*    */   
/*    */   public int getPhase() {
/* 28 */     return this.phase;
/*    */   }
/*    */   
/*    */   public void setPhase(int x) {
/* 32 */     this.phase = x;
/*    */   }
/*    */   
/*    */   public int getHeightContribution() {
/* 36 */     return this.heightContribution;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void readFromNBT(NBTTagCompound nbt) {
/* 42 */     this.age = nbt.getInteger("Age");
/* 43 */     this.phase = nbt.getInteger("Phase");
/* 44 */     this.heightContribution = nbt.getInteger("HeightContribution");
/* 45 */     super.readFromNBT(nbt);
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
/* 50 */     nbt.setInteger("Age", this.age);
/* 51 */     nbt.setInteger("Phase", this.phase);
/* 52 */     nbt.setInteger("HeightContribution", this.heightContribution);
/* 53 */     return super.writeToNBT(nbt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\TileEntityPlant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
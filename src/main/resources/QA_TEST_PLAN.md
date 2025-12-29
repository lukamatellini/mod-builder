# Mod QA Test Plan: Lucky Blocks

**Mod ID:** `luckyblocks`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-29T03:29:30.947Z
**Total Tests:** 6

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p luckyblocks:minecraftair
/give @p luckyblocks:living_wood
```

## Items

### 🤖 Minecraftair Registration

**Command:** `/give @p luckyblocks:minecraftair`

**Steps:**
1. Run: /give @p luckyblocks:minecraftair
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Living Wood Registration

**Command:** `/give @p luckyblocks:living_wood`

**Steps:**
1. Run: /give @p luckyblocks:living_wood
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Minecraftair Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:cobblestone","luckyblocks:living_wood"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Minecraftair

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Lucky Block Placement

**Command:** `/give @p luckyblocks:lucky_block`

**Steps:**
1. Run: /give @p luckyblocks:lucky_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

## Structures

### 👤 Small Stone Building Location

**Command:** `/locate structure luckyblocks:small_stone_building`

**Steps:**
1. Run: /locate structure luckyblocks:small_stone_building
2. Teleport to structure
3. Verify structure generated correctly

**Expected:** Structure can be located and renders correctly

- [ ] PASS
- [ ] FAIL: _________________

## Structure Loot

### 👤 Small Stone Building Chest Loot

**Steps:**
1. Locate structure
2. Find loot chests
3. Open chests
4. Verify loot is generated

**Expected:** Chests contain expected loot

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 2 | [ ] | [ ] |
| Recipes | 1 | [ ] | [ ] |
| Blocks | 1 | [ ] | [ ] |
| Structures | 1 | [ ] | [ ] |
| Structure Loot | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_
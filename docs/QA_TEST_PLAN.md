# QA Test Plan: Aged Wedge

Generated: 2025-12-29T12:22:33.356Z
Minecraft Version: 1.21.1
Mod ID: agedwedge

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 27 |
| Passed | 20 |
| Failed | 0 |
| Warnings | 3 |
| Skipped | 4 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `agedwedge.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Cheese Block | `/give @p agedwedge:cheese_block` | ☐ | ☐ | ☐ |
| Modcheese Block | `/give @p agedwedge:modcheese_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
